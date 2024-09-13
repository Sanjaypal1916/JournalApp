package com.BackendSphere.journalApplication.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.BackendSphere.journalApplication.Entity.user;

@Repository
public interface userrepo extends MongoRepository<user, String>{

	Optional<user> findByUsername(String username);

}
