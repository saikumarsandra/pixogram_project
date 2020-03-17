package com.cts.training.commentservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.training.commentservice.model.CommentsCountModel;

@Repository
public class CustomRepoImplementation implements CustomRepo {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public CommentsCountModel findCountById(Integer mediaid) {
		// TODO Auto-generated method stub
		TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(*) FROM Comments c WHERE mediaId=:mediaid",Long.class);
		Long count = (long) query.getFirstResult();
		Integer a = Math.toIntExact(count);
		CommentsCountModel data = new CommentsCountModel(a);
		
		return data;
	}

}
