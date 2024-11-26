package com.BackendSphere.journalApplication.schedular;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.BackendSphere.journalApplication.Entity.entries;
import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.model.sentimentData;
import com.BackendSphere.journalApplication.repo.SAcriteriarepo;
import com.BackendSphere.journalApplication.service.emailservice;
import com.BackendSphere.journalApplication.service.sentimentAnalyis;

@Service
public class userschedular {
	
	@Autowired
	private emailservice email;
	@Autowired
	private SAcriteriarepo repo;
	@Autowired
	private sentimentAnalyis SA;
	
	@Autowired
	private KafkaTemplate<String , String> kafkatemplate;
	
	
	@Scheduled(cron = "0 0 9 * * SUN")
	public void fetchusersandsendSAmails() {
		List<user> users =repo.getUsersWthSA();
		for (user user : users) {
			
			List<entries> entries1 = user.getEntries();
			List<String> filteredentries = entries1.stream().filter(x->x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getContent()).collect(Collectors.toList());
			String entry = String.join("......", filteredentries);
			String sentiment = SA.getsentiment(entry);
			
			
			
			try {
				
				kafkatemplate.send("weekly", user.getEmail(), sentiment);
//								client,         key      ,  content
			} catch (Exception e) {
				email.sendemail(user.getEmail(), "Sentiment Analysis for last 7 days ", sentiment);
			}
		}
	}

}
