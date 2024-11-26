package com.BackendSphere.journalApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class sentimentconsumerservice {

	
	@Autowired
	private emailservice email;
	
	@KafkaListener(topics = "weekly", groupId = "weekly-group")
	public void consume(String sentiment) {
		sendemail(sentiment);
	}

	private void sendemail(String sentiment) {
		String gmail = "sanjudada1916@gmail.com";
		String subject = "sentiment";
		
		email.sendemail(gmail, subject, sentiment);
		
	}
}
