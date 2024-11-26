package com.BackendSphere.journalApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.repo.SAcriteriarepo;

@Service 
public class criteriaservice {
	
	@Autowired
	private SAcriteriarepo SA;
	
	public List<user> getSAcriteria() {
		List<user> users =SA.getUsersWthSA();
		return users;
	}

}
