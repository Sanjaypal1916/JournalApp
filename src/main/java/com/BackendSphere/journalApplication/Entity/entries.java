package com.BackendSphere.journalApplication.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Document(collection="journalEntries")
@NoArgsConstructor
public class entries {
	

	@Id
	private  String id;
	@NonNull
	private String title;
	private String content;
	private LocalDateTime date;
	
	
	

}
