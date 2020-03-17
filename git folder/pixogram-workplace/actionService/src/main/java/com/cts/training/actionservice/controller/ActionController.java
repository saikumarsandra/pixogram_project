package com.cts.training.actionservice.controller;

import java.util.List;
import java.util.Optional;

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

import com.cts.training.actionservice.entity.Action;
import com.cts.training.actionservice.model.ActionData;
import com.cts.training.actionservice.model.ActionModel;
import com.cts.training.actionservice.model.ActionsCountModel;
import com.cts.training.actionservice.repository.ActionRepository;
import com.cts.training.actionservice.service.IActionService;


@RestController
public class ActionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IActionService actionService;

	
	@GetMapping("/action")
	public ResponseEntity<ActionModel> getallactions(){
		ActionModel data = new ActionModel();
		data.setActionlist(this.actionService.getall());
		ResponseEntity<ActionModel> result = new ResponseEntity<ActionModel>(data, HttpStatus.OK);
		return result;
		
	}
	
	@GetMapping("/getlikes/{id}")
	public ResponseEntity<ActionsCountModel> getLikes(@PathVariable Integer id) {
		ActionsCountModel count = this.actionService.getLikesByMediaId(id);
		ResponseEntity<ActionsCountModel> result = new ResponseEntity<ActionsCountModel>(count,HttpStatus.OK);
		return result;
		
	}
	
	@PostMapping("/action")
	public boolean save(@RequestBody ActionData action) {
		this.actionService.save(action);
		return true;
	}
	@GetMapping("/action/{actionId}")
	public ResponseEntity<ActionData> getById(@PathVariable Integer actionId){
		ActionData data = new ActionData();
		Action record = new Action();
		Optional<Action> action = this.actionService.getWithId(actionId);
		if(action.isPresent())
			record = action.get();
		else {
			//throw new ActionNotFoundException("action not found");
		}
		data.setId(record.getId());
		data.setUserId(record.getUserId());
		data.setMediaId(record.getMediaId());
		data.setStatus(record.getStatus());
		ResponseEntity<ActionData> result = new ResponseEntity<ActionData>(data, HttpStatus.OK);
		return result;
	}
	
	
	//update user
	@PutMapping("/action")
	public boolean update(@RequestBody ActionData user) {
		
		this.actionService.updateuser(user);
		return true;
		
	}
}











