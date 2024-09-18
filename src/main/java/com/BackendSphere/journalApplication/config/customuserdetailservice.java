package com.BackendSphere.journalApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.BackendSphere.journalApplication.Entity.user;
import com.BackendSphere.journalApplication.repo.userrepo;

@Component
public class customuserdetailservice implements UserDetailsService{
	
	@Autowired
	private userrepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user = userrepo.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("username not found"));
		if(user!=null) {
			return User.builder()
			.username(user.getUsername())
			.password(user.getPassword())
			.roles(user.getRoles().toArray(new String[0]))
			.build();
			
		}
		return null;
	}

	
}
