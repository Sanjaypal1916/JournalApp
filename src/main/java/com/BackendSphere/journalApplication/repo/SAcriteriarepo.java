package com.BackendSphere.journalApplication.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.BackendSphere.journalApplication.Entity.user;

@Repository
public class SAcriteriarepo {
	
	@Autowired
	private MongoTemplate mongotemplate;
	

	
	public List<user> getUsersWthSA(){
		
		
		Query query = new Query();
		query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
//		query.addCriteria(Criteria.where("email").exists(true).ne(null).ne(""));
		query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
		
//		Criteria criteria = new Criteria();
//		query.addCriteria(criteria.orOperator(Criteria.where("email").exists(true), criteria.where("snetimentAnalysis").is("true")));
		
		List<user> users = mongotemplate.find(query, user.class);
		return users;
		
	}
	
	
}
