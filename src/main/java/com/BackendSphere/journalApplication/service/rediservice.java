package com.BackendSphere.journalApplication.service;

import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.BackendSphere.journalApplication.Entity.weatherPojo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class rediservice {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	
	
	public <T> T get(String key, Class<T> weatherPojoClass) {
		
		try {

			Object o = redisTemplate.opsForValue().get(key);
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(o.toString(), weatherPojoClass);
		} 
		catch (Exception e) {
			
			log.info("EXCEPTION :::: " + e);
			return null;
		}
	}
	
	
	public void set(String key, Object o , Long ttl) {
		
		try {
			redisTemplate.opsForValue().set(key, o, ttl, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.info("EXCEPTION :::: " + e);
		}
		
	}


	

}
