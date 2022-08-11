package com.hipradeep.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hipradeep.blog.entities.User;
import com.hipradeep.blog.exceptions.ResourceNotFoundException;
import com.hipradeep.blog.repositories.UserRepo;


@Service
public class CustomeUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User ", "Email : "+username, 0));
		return user;
	}

}
