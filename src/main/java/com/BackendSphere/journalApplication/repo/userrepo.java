package com.BackendSphere.journalApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BackendSphere.journalApplication.Entity.user;

@Repository
public interface userrepo extends MongoRepository<user, String>{

}
