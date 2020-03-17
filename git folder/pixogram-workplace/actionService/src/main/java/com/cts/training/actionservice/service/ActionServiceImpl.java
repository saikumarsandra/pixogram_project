package com.cts.training.actionservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.training.actionservice.entity.Action;
import com.cts.training.actionservice.model.ActionData;
import com.cts.training.actionservice.model.ActionsCountModel;
import com.cts.training.actionservice.repository.ActionRepository;
import com.cts.training.actionservice.repository.CustomRepository;



// @Component
@Service
public class ActionServiceImpl implements IActionService {

	@Autowired
	private ActionRepository actionRepository;
	@Autowired
	private CustomRepository custom;
	

	public List<Action> getall(){
		List<Action> records =this.actionRepository.findAll();
		return records;
		
	}
	
	public void save(ActionData action) {
		Action data = new Action();
		data.setMediaId(action.getMediaId());
		data.setStatus(action.getStatus());
		data.setUserId(action.getUserId());
		this.actionRepository.save(data);
		
	}
	
	public Optional<Action> getWithId(Integer id){
		Optional<Action> record= this.actionRepository.findById(id);
		return record;
		
	}
	
	public void updateuser(ActionData action) {
		Action data = new Action();
		data.setMediaId(action.getMediaId());
		data.setStatus(action.getStatus());
		data.setUserId(action.getUserId());
		data.setId(action.getId());
		this.actionRepository.save(data);
	}

	@Override
	public ActionsCountModel getLikesByMediaId(Integer id) {
		// TODO Auto-generated method stub
		ActionsCountModel count = this.custom.getLikes(id);
		return count;
	}

}
