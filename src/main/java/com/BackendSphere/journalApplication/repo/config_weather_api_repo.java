package com.BackendSphere.journalApplication.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.BackendSphere.journalApplication.Entity.config_weather_api;

public interface config_weather_api_repo extends MongoRepository<config_weather_api , ObjectId>{

}
