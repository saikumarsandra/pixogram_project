package com.cts.training.actionservice.service;

import java.util.List;

import com.cts.training.actionservice.entity.Action;
import com.cts.training.actionservice.model.ActionData;
import com.cts.training.actionservice.model.ActionsCountModel;

import java.util.List;
import java.util.Optional;

public interface IActionService {
	
	public List<Action> getall();
	public void save(ActionData action);
	public Optional<Action> getWithId(Integer id);
	public void updateuser(ActionData action);
	public ActionsCountModel getLikesByMediaId(Integer id);
	
}
