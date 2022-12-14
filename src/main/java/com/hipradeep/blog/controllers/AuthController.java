package com.hipradeep.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hipradeep.blog.payloads.JwtAuthRequest;
import com.hipradeep.blog.payloads.JwtAuthResponse;
import com.hipradeep.blog.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		System.out.println("************************"+request.getUsername()+"   "+ request.getPassword()+"******************************");
		this.authentication(request.getUsername(), request.getPassword());
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		//String token=this.jwtTokenHelper.generateToken(userDetails);
		//System.out.println(token+"******************************************************");
		JwtAuthResponse response=new JwtAuthResponse(); 
		
		response.setToken(""); 
		
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	
		
	}

	private void authentication(String username, String password) throws Exception{
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			
			this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
		}catch(BadCredentialsException e) {
			System.out.println("Bad Credentials   !!!");
			throw new Exception("Bad Credentials   !!");
		}
	}

}
