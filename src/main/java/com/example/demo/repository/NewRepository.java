package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.NewDTO;
import com.example.demo.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	NewEntity findOneById(Long id);
	 List<NewDTO> findAllByTitle(String title, Pageable pageable);
	 
}
