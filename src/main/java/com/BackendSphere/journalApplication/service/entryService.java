package com.BackendSphere.journalApplication.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BackendSphere.journalApplication.Entity.entries;
import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.repo.entryRepo;
import com.BackendSphere.journalApplication.repo.userrepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class entryService {

	
	@Autowired
	private entryRepo repo;
	

	@Autowired
	private userservice uservice;
	
//getall done
	public List<entries> getall(String user) {
		user u1 = uservice.getuserbyusername(user);
		List<entries> entire =u1.getEntries();
		return entire;
		}
	
	
//getbyid done	
	public entries getbyid(String user,String id) {
		
		user u1 = uservice.getuserbyusername(user);
		List<entries> li =u1.getEntries();
		entries e =(entries) li.stream().map(x->x.getId()==id);
//		entries entry = repo.findById(id).orElseThrow(()->new RuntimeException());
		return e;
		}
	
	
//post done
	@Transactional
	public entries create(entries entry,String user) {
		user u1 = uservice.getuserbyusername(user);
		entry.setDate(LocalDateTime.now());
		if(u1!=null) {
			entries e1 = repo.save(entry);
			u1.getEntries().add(e1);
			uservice.create(u1);
			return e1;			
		}else {
			return null;
		}
		}
	
	public entries saventry(entries entry) {
		return repo.save(entry);
	}
	
	
	public entries update(String user,String id,entries entry) {
		entries e1 = repo.findById(id).orElseThrow(()->new RuntimeException());
		e1.setContent(entry.getContent());
		e1.setDate(LocalDateTime.now());
		e1.setTitle(entry.getTitle());
		repo.deleteById(id);
		return repo.save(e1);
	}
	
	
//delete done	
	public boolean delete(String user,String id) {
		user u = uservice.getuserbyusername(user);
		if(u==null) {
			return false;
		}
		else {
			u.getEntries().removeIf(x->x.getId().equals(id));
//			repo.deleteById(null);
			uservice.create(u);
			return true;
		}
		}
	
	
}
