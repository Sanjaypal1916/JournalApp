package com.BackendSphere.journalApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.repo.userrepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class userservice {
	
	@Autowired
	private userrepo repo;
	
	public List<user> getall(){
		return repo.findAll();
		
	}
	
	public user getbyid(String id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException());
		
	}
	
	public user create(user user) {
		return repo.save(user);
		
	}
	
	public user update(String id, user user) {
		user u1 = repo.findById(id).orElse(null);
		
		if(u1==null){
			return null;
		}else {
			u1.setPassword(user.getPassword());
			u1.setUsername(user.getUsername());
			return repo.save(u1);
		}
		
		
		
	}
	
	public boolean delete(String id) {
		user u = repo.findById(id).orElse(null);
		
		if(u!=null) {
			repo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	

}
