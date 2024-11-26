package com.BackendSphere.journalApplication.criteria;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BackendSphere.journalApplication.repo.SAcriteriarepo;

@SpringBootTest
public class criteria {
	
	@Autowired
	private SAcriteriarepo SA;
	
	@Test
	private void getSAcriteria() {
		SA.getUsersWthSA();
	}
}
