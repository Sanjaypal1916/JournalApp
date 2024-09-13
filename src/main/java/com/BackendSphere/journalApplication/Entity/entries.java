package com.BackendSphere.journalApplication.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection="journalEntries")
@NoArgsConstructor
public class entries {
	

	@Id
	private  String id;
	@Nonnull
	private String title;
	private String content;
	private Date date;
	
	public void setDate(LocalDateTime now) {
		this.date = date;
	}
	
	

}
