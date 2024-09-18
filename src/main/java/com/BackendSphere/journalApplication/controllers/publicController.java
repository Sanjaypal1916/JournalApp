package com.BackendSphere.journalApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.service.userservice;

@RestController
@RequestMapping("/public")
public class publicController {


	@Autowired
	private userservice service;
	
	@GetMapping("/health")
	public  String health(){
		return "ok";
	}
	
	@PostMapping("/create")
	public  user save(@RequestBody user user){
		return service.create(user);
	}
}
