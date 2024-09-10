package com.BackendSphere.journalApplication.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BackendSphere.journalApplication.Entity.entries;

@Repository
public interface entryRepo extends MongoRepository<entries,String>{

}
