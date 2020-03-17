package com.cts.training.followservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.followservice.entity.Follow;
import com.cts.training.followservice.model.FollowData;
import com.cts.training.followservice.model.FollowModel;
import com.cts.training.followservice.repository.FollowRepository;

@RestController
public class FollowController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FollowRepository followRepository;
	
	/*@Autowired
	private IFollowService followService;
	*/
	@GetMapping("/check-followings/mine/{mineId}/other/{otherId}")
	public ResponseEntity<Boolean> getFollowingStatus(@PathVariable Integer mineId, @PathVariable Integer otherId){
		
		Boolean status = this.followRepository.checkFollowing(mineId, otherId);
		ResponseEntity<Boolean> result = new ResponseEntity<Boolean>(status,HttpStatus.OK);
		return result;
		
	}
	/*
	@GetMapping("/follow")
	public ResponseEntity<FollowModel> getallfollows(){
		FollowModel data = new FollowModel();
		data.setFollowlist(this.followService.getall());
		ResponseEntity<FollowModel> result = new ResponseEntity<FollowModel>(data,HttpStatus.OK);
		return result;
		
	}
	
	@PostMapping("/follow")
	public Boolean save(@RequestBody FollowData follow)
	{
		this.followService.save(follow);
		return true;
	}*/
	@PostMapping("/follow")
	public Boolean follow(@RequestBody Follow follow) {
		Boolean status  = this.followRepository.follow(follow);
		return status;
	}
	
	@DeleteMapping("/unfollow/mine/{mineId}/other/{otherId}")
	public Boolean unfollow(@PathVariable Integer mineId , @PathVariable Integer otherId) {
		logger.info(mineId+"--------"+otherId);
		Boolean status = this.followRepository.unFollow(mineId, otherId);
		return status;
	}
}
