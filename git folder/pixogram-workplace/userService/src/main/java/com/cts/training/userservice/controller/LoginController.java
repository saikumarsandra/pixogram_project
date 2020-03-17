package com.cts.training.userservice.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.training.userservice.entity.Users;
import com.cts.training.userservice.model.ResponseData;
import com.cts.training.userservice.model.UserInput;
import com.cts.training.userservice.model.Usernames;
import com.cts.training.userservice.repository.UserRepository;
import com.cts.training.userservice.service.IUserService;
import com.cts.training.userservice.service.StorageService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {
     
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// testing end-point
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StorageService storageService;
	
	/*
	@GetMapping("/login")
	public ResponseEntity<ResponseData> login() {
		// if called then credentials are valid
		logger.info("Logged In...");
		
		ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis());

		ResponseEntity<ResponseData> response = 
					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		
		return response;
		
	}*/
	
	
	
	
	
	  
	@GetMapping("/login")
		public ResponseEntity<ResponseData> login(HttpServletRequest request) {
			// if called then credentials are valid
			
			String authorization = request.getHeader("Authorization");
			String[] values = null;
			
			if (authorization != null && authorization.startsWith("Basic")) {
			    // Authorization: Basic base64credentials
			    String base64Credentials = authorization.substring("Basic".length()).trim();
			    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			    // credentials = username:password
			    values = credentials.split(":", 2);
			}
			
			
			logger.info("Logged In...");
			logger.info(values[0]);
			logger.info(values[1]);
	        
	        Users user = this.userRepository.findByUsernameContaining(values[0]).get(0);
	        logger.info("User : " + user);
	        // add any additional information like firstname, lastname, profilepic etc
			ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis(), user.getId());

			ResponseEntity<ResponseData> response = 
						new ResponseEntity<ResponseData>(data, HttpStatus.OK);
			
			return response;
			
		}
	
	
	
	
	

	@PostMapping("/register") // POST HTTP VERB
	// public ResponseEntity<Product> save(@RequestBody Product product)
	public ResponseEntity<UserInput> save(@RequestParam("file") MultipartFile file,
			@RequestParam("userName") String userName, 
			
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("profile") String profile
			) {
		
		// explicitly need to create product object
		UserInput user = new UserInput();
		user.setUsername(userName);	
		
		user.setPassword(password);
		user.setEmail(email);
		user.setProfile(profile);
		this.userService.addUser(user);
		this.storageService.store(file);
		
		return null;
	}
	
	

	@GetMapping("/usernames")
	public ResponseEntity<Usernames> getUserNames(){
		List<String> names = new ArrayList<String>();
		names = this.userService.getUsernames();
		Usernames data = new Usernames(names);
		ResponseEntity<Usernames> result = new ResponseEntity<Usernames>(data,HttpStatus.OK);
		return result;
		
	}
	
	
	
	
	
	}