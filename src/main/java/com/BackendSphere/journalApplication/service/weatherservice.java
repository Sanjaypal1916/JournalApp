package com.BackendSphere.journalApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BackendSphere.journalApplication.Entity.weatherPojo;
import com.BackendSphere.journalApplication.cache.AppCache;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class weatherservice {
//	API access key - 7d54e4fd1a542644f66fe9789e32fb7e
	
	@Value("${weather_api_key}")
	private String API_access_key;
	
	@Autowired
	private AppCache appcache;
	
	private static final String api = "http://api.weatherstack.com/current?access_key=APIKEY&query=delhi";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private  rediservice rediservice;

	public weatherPojo getweather(String city) {
		String replacedAPI = appcache.APPCACHE.get("weather_API");
		weatherPojo weather = rediservice.get("weather_of_"+city, weatherPojo.class);
		
		
		if(weather != null) {
			return weather;
		}else {
			String replace = api.replace("APIKEY", API_access_key );
			log.info(replace);
			
			ResponseEntity<weatherPojo> response =restTemplate.exchange(replacedAPI, HttpMethod.GET, null, weatherPojo.class);
			weatherPojo body =response.getBody();
			log.info(body.toString());
			
			if(body != null) {
				rediservice.set("weather_of_"+city, body, 300l);
			}
			
			return body;
		}
		
	}
	
}
