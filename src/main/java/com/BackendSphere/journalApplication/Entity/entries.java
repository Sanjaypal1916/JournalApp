package com.BackendSphere.journalApplication.Entity;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="journalEntries")
public class entries {
	@Id
	private  String id;
	private String title;
	private String content;
	private Date date;

}
