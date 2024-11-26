package com.BackendSphere.journalApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class emailservice {

	@Autowired
	private JavaMailSender mailsender;
	
	public void sendemail(String to, String subject, String Body) {
				try {
					SimpleMailMessage mail = new SimpleMailMessage();
					mail.setTo(to);
					mail.setSubject(subject);
					mail.setText(Body);
					
					mailsender.send(mail);
					
					
				} catch (Exception e) {
					log.error("EXCEPTION:",e);
				}						
	}
}
  