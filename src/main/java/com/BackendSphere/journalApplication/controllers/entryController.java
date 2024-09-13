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
import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.service.entryService;
import com.BackendSphere.journalApplication.service.userservice;

@RestController
public class entryController {

	@Autowired
	private userservice uservice;
	
	@Autowired
	private entryService service;
	
	@GetMapping("/{username}")
	public ResponseEntity<List<entries>>  getall(@PathVariable String username){
		return ResponseEntity.ok(service.getall(username));
	}
	
	@GetMapping("{username}/{id}")
	public ResponseEntity<entries> getbyid(@PathVariable String username,@PathVariable String id){
		return ResponseEntity.ok(service.getbyid(username,id));
	}
	
	@PostMapping("/{username}")
	public ResponseEntity<?> create(@PathVariable String username,@RequestBody entries e1){
		service.create(e1,username);
		return ResponseEntity.ok(e1);
		
	}
	
	@PutMapping("/{username}/{id}")
	public entries update(@PathVariable String username,@PathVariable String id, @RequestBody entries e1 ){
		return service.update(username,id,e1);
	}
	
	@DeleteMapping("/{username}/{id}")
	public boolean delete(@PathVariable String username,@PathVariable String id){
		return service.delete(username,id);
	}
	
	
	
}
