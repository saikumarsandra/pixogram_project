package com.cts.training.actionservice.repository;

import com.cts.training.actionservice.model.ActionsCountModel;

public interface CustomRepository {

	public ActionsCountModel getLikes(Integer mediaId);
}
