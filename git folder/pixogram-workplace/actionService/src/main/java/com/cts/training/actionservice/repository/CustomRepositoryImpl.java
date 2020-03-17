package com.cts.training.actionservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cts.training.actionservice.model.ActionsCountModel;

public class CustomRepositoryImpl  implements CustomRepository{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ActionsCountModel getLikes(Integer id) {
		// TODO Auto-generated method stub
		TypedQuery<Long> query = entityManager.createQuery("select count(*) from Actions a where mediaId=:id and status=true",Long.class);
		query.setParameter("id",id);
		TypedQuery<Long> query1 = entityManager.createQuery("select count(*) from Actions a where mediaId=:id and status=false",Long.class);
		query1.setParameter("id",id);
		
		Long count = (long) query.getFirstResult();
		Long count1 = (long) query1.getFirstResult();
		Integer likes = Math.toIntExact(count);
		Integer unlikes  = Math.toIntExact(count1);
		ActionsCountModel result = new ActionsCountModel(likes, unlikes);
		return result;
	}
	
	


}
