package com.BackendSphere.journalApplication.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class redisconfig {

//	@Bean
//	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
//		
//		RedisTemplate<Object, Object> redistemplate = new RedisTemplate<>();
//		redistemplate.setConnectionFactory(factory);
//		redistemplate.setKeySerializer(new StringRedisSerializer());
//		redistemplate.setValueSerializer(new StringRedisSerializer());
//		return redistemplate;
//		
//	}
	


}
