package com.cts.training.commentservice.repository;

import com.cts.training.commentservice.model.CommentsCountModel;

public interface CustomRepo {
	
	public CommentsCountModel findCountById(Integer mediaid);
}
