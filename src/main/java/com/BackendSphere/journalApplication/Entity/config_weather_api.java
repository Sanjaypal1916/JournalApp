package com.BackendSphere.journalApplication.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document("config_journal_app")
@Data
@NoArgsConstructor
public class config_weather_api {
	private String key;
	private String value;
}
