package com.BackendSphere.journalApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.service.userservice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class usercontroller {
	
	@Autowired
	private userservice service;

	@GetMapping
	public  List<user> getall(){
		return service.getall();
	}
	
	
	
	@PutMapping
	public  user updatebyid(@RequestBody user user){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String userid = auth.getName();
		return service.update(userid, user);
	}
	
	@DeleteMapping("/{id}")
	public boolean deletebyid(@PathVariable String id) {
		return service.delete(id);
	}
	
	@GetMapping("/{username}")
	public user getuserbyname(@PathVariable String username) {
		user u = service.getuserbyusername(username);
		if(u==null) {
			return null;
		}else {
			return u;
		}
	}
	
	
	
}
