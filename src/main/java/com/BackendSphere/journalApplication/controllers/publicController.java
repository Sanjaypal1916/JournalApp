package com.BackendSphere.journalApplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.Entity.weatherPojo;
import com.BackendSphere.journalApplication.config.customuserdetailservice;
import com.BackendSphere.journalApplication.service.criteriaservice;
import com.BackendSphere.journalApplication.service.emailservice;
import com.BackendSphere.journalApplication.service.userservice;
import com.BackendSphere.journalApplication.service.weatherservice;
import com.BackendSphere.journalApplication.utils.JWTutils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/public")
@Slf4j
public class publicController {

	@Autowired
	private criteriaservice criteriaservice;
	
	@Autowired
	private userservice service;
	
	@Autowired
	private weatherservice wservice;
	
	@Autowired
	private emailservice email;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private customuserdetailservice userdetails;
	
	@Autowired
	private JWTutils jwtutils;
	
	@GetMapping("/health")
	public  String health(){
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		weatherPojo res = wservice.getweather("delhi");
		int hola = res.getCurrent().getFeelslike();
		return "hi"+username+", todays weather feels like "+hola;
	}
	
	
	
	@PostMapping("/signup")
	public  user save(@RequestBody user user){
		return service.create(user);
	}
	
	
	@GetMapping("/crit")
	public List<user> getusersfromcriteria() {
		List<user> users=criteriaservice.getSAcriteria();
		return users;
	}
	
	@PostMapping("/email")
	public boolean sendemail() {
		
		try {
			email.sendemail("sanjudada1916@gmail.com", "testing emailservice", "To kese hain aap log");
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	@PostMapping("/login")
	public  ResponseEntity<?> login(@RequestBody user user){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			UserDetails user1 = userdetails.loadUserByUsername(user.getUsername());
			String jwt =jwtutils.generateToken(user1.getUsername()); 
			return ResponseEntity.ok(jwt);
			
			
		} catch (Exception e) {
			log.info("EXCEPTION :::: " + e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("EXCEPTION :::: " +e);
		}
	}
}
