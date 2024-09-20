package com.BackendSphere.journalApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.entries;
import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.service.entryService;
import com.BackendSphere.journalApplication.service.userservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/entry")
@RequiredArgsConstructor
public class entryController {

	@Autowired
	private userservice uservice;
	
	@Autowired
	private entryService service;
	
	@GetMapping()
	public ResponseEntity<List<entries>>  getall(){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return ResponseEntity.ok(service.getall(username));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<entries> getbyid(@PathVariable String id){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return ResponseEntity.ok(service.getbyid(username,id));
	}
	
	@PostMapping()
	public ResponseEntity<?> create(@RequestBody entries e1){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		service.create(e1,username);
		return ResponseEntity.ok(e1);
		
	}
	
	@PutMapping("/{id}")
	public entries update(@PathVariable String id, @RequestBody entries e1 ){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return service.update(username,id,e1);
	}
	
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable String id){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return service.delete(username,id);
	}
	
	
	
}
