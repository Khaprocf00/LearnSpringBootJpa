package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.api.output.NewOutput;
import com.example.demo.converter.NewConverter;
import com.example.demo.dto.NewDTO;
import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.NewEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.INewService;

@Service
public class NewService implements INewService {
	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepositoy;
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if (newDTO.getId() != null) {
			NewEntity oldNewEntity = newRepository.findOneById(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
		} else {
			newEntity = newConverter.toEntity(newDTO);
		}
		CategoryEntity category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		UserEntity user = userRepositoy.findOneByUserName(newDTO.getUserCode());
		newEntity.setCategory(category);
		newEntity.setUser(user);
		newRepository.save(newEntity);
		return newConverter.toDto(newEntity);
	}

	public void delete(Long[] ids) {
		for (Long id : ids) {
			newRepository.deleteById(id);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity item : entities) {
			NewDTO newDTO = newConverter.toDto(item);
			results.add(newDTO);
		}
		if (results.size() == 0) {
			return null;
		}
		return results;
	}
	

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}
}
