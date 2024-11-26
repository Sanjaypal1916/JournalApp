package com.BackendSphere.journalApplication.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BackendSphere.journalApplication.Entity.config_weather_api;
import com.BackendSphere.journalApplication.repo.config_weather_api_repo;

@Component
public class AppCache {
	
	public Map<String, String> APPCACHE = new HashMap<>();
	
	@Autowired
	private config_weather_api_repo wrepo;
	
	@PostConstruct
	public void init() {
		List<config_weather_api> all = wrepo.findAll();
		for(config_weather_api configweatherapi : all ) {
			APPCACHE.put(configweatherapi.getKey(), configweatherapi.getValue());
		}
	}
	
	

}
