package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.output.NewOutput;
import com.example.demo.dto.NewDTO;
import com.example.demo.service.impl.NewService;

@CrossOrigin
@RestController
public class NewAPI {
	
	@Autowired
	private NewService newService;
	
	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam("page") int page,@RequestParam("limit") int limit) {
		NewOutput results = new NewOutput();
		results.setPage(page);
		Pageable pageable = PageRequest.of(page-1, limit);
		results.setListResult(newService.findAll(pageable));
		results.setTotalPage((int) (Math.ceil((double) (newService.totalItem())/ limit)));
		return results;
	}

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newService.save(model);
	}
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model,@PathVariable("id") long id) {
		model.setId(id);
		return newService.save(model);
	}
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody Long[] ids) {
		newService.delete(ids);
	}
	
}

