package com.BackendSphere.journalApplication.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class redistest {
	
	@Autowired
	private RedisTemplate redistemplate;
	
	@Test
	public void testsendmail() {
		redistemplate.opsForValue().set("email","sanjay@gmail.com");
		Object email = redistemplate.opsForValue().get("email");
		int a = 1;
	}

}
