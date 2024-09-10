package com.BackendSphere.journalApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BackendSphere.journalApplication.Entity.entries;
import com.BackendSphere.journalApplication.repo.entryRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class entryService {

	
	@Autowired
	private entryRepo repo;
	
	
	
	public List<entries> getall() {
		List<entries> entire =repo.findAll();
		return entire;
		}
	
	
	
	public entries getbyid(String id) {
		entries entry = repo.findById(id).orElseThrow(()->new RuntimeException());
		return entry;
		}
	
	
	
	public entries create(entries entry) {
		entries e1 = repo.save(entry);
		return e1;
		}
	
	
	
	public entries update(String id,entries entry) {
		entries e1 = repo.findById(id).orElseThrow(()->new RuntimeException());
		e1.setContent(entry.getContent());
		e1.setDate(entry.getDate());
		e1.setTitle(entry.getTitle());
		repo.deleteById(id);
		return repo.save(e1);
	}
	
	
	
	public boolean delete(String id) {
		entries e1 =  repo.findById(id).orElse(null);
		if(e1==null) {
			return false;
		}
		else {
			repo.deleteById(id);
			return true;
		}
		}
	
	
}
