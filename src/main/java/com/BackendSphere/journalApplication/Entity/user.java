package com.BackendSphere.journalApplication.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "user")
public class user {
	
	@Id
	private String id;
	@Indexed(unique = true)
	@NonNull
	private String username;

	@NonNull
	private String password;
	
	@DBRef
	private List<entries> entries= new ArrayList<>();
}
