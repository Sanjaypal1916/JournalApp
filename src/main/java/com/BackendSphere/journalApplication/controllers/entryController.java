package com.BackendSphere.journalApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.entries;
import com.BackendSphere.journalApplication.service.entryService;

@RestController
public class entryController {

	
	@Autowired
	private entryService service;
	
	@GetMapping()
	public ResponseEntity<List<entries>>  getall(){
		return ResponseEntity.ok(service.getall());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<entries> getbyid(@PathVariable String id){
		return ResponseEntity.ok(service.getbyid(id));
	}
	
	@PostMapping()
	public entries create(@RequestBody entries e1){
		return service.create(e1);
	}
	
	@PutMapping("/{id}")
	public entries update(@PathVariable String id, @RequestBody entries e1 ){
		return service.update(id,e1);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable String id){
		return service.delete(id);
	}
	
	
	
}
