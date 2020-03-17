package com.cts.training.Blockservice.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.Blockservice.entity.BlockedUser;
import com.cts.training.Blockservice.repository.BlockedUserRepository;
import com.cts.training.Blockservice.service.IBlockedUserService;



@RestController
public class BlockedUserController {

	// dependency
	@Autowired
	private IBlockedUserService blockedUserservice;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@GetMapping("/blockedUser") // GET HTTP VERB
	public ResponseEntity<List<BlockedUser>> exposeAll() {
		
		List<BlockedUser> blockedUser = this.blockedUserservice.findAllBlockedUser();
		ResponseEntity<List<BlockedUser>> response = 
								new ResponseEntity<List<BlockedUser>>(blockedUser, HttpStatus.OK);
		
		
		return response;
	}	
	
	// REST method that will recieve a movie Id and return details of that movie
	@GetMapping("/blockedUser/{blockedUserId}") // GET HTTP VERB
	public ResponseEntity<BlockedUser> getById(@PathVariable Integer blockedUserId) {
		
		BlockedUser BlockedUser = this.blockedUserservice.findBlockedUserById(blockedUserId);
		ResponseEntity<BlockedUser> response = 
				new ResponseEntity<BlockedUser>(BlockedUser, HttpStatus.OK);

		return response;
	}
	
	
	
	@PostMapping("/blockedUser") // POST HTTP VERB
	public ResponseEntity<BlockedUser> save(@RequestBody BlockedUser blockedUser) {
		this.blockedUserservice.addBlockedUser(blockedUser);
		ResponseEntity<BlockedUser> response = 
				new ResponseEntity<BlockedUser>(blockedUser, HttpStatus.OK);

		return response;
	}
	
	
	
	@PutMapping("/blockedUser/{blockedUserId}")
	
		public ResponseEntity<BlockedUser> saveUpdate(@PathVariable Integer blockedUserId,@RequestBody BlockedUser blockedUser) {
		
		BlockedUser b = new BlockedUser (blockedUserId,blockedUser.getBlockedUserId());

		if(!this.blockedUserservice.updateBlockedUser(b))
			throw new RuntimeException("could not update");
			
		ResponseEntity<BlockedUser> response = 
				new ResponseEntity<BlockedUser>(b, HttpStatus.OK);

		return response;
	}
	
	
	
	
	
	@DeleteMapping("/blockedUser/{blockedUserId}")
	public ResponseEntity<BlockedUser> delete(@PathVariable Integer blockedUserId) {
		
		BlockedUser blockedUser = this.blockedUserservice.findBlockedUserById(blockedUserId);
		this.blockedUserservice.deleteBlockedUser(blockedUserId);
		
		ResponseEntity<BlockedUser> response = 
				new ResponseEntity<BlockedUser>(blockedUser, HttpStatus.OK);

		return response;
	}
	
	
	
}













