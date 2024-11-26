package com.BackendSphere.journalApplication.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.repo.userrepo;

@SpringBootTest
public class userServiceTest {
	
	@Autowired
	private userrepo repo;

	
		@Disabled
		@Test
		public void testAdd() {
			assertEquals(4, 2+2);
		}
		
		
		
		@ParameterizedTest
		@CsvSource({
			"1,2,3",
			"3,3,6",
			"6,6,12"
		})
		public void test(int a , int b , int c) {
			assertEquals(c ,  a+b);
		}
		
		
		@ParameterizedTest
		@ArgumentsSource(UserArgumentProvider.class)
		public void testFindByUsername(user name) {
//			assertNotNull(name);
		}
		
		
}
