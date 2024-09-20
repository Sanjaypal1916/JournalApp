package com.BackendSphere.journalApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.service.userservice;

@RestController
@RequestMapping("/admin")
public class admincontroller {

	@Autowired
	private userservice service;

	@GetMapping("/allusers")
	public  List<user> getall(){
		return service.getall();
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
	
	
	@PostMapping("/createAdmin")
	public  user save(@RequestBody user user){
		return service.createAdmin(user);
	}
	
}
