package com.cts.training.userservice.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cts.training.userservice.entity.Authorities;



@Repository
@Transactional
public class RolesRepoImp implements RolesRepository {
	
	@PersistenceContext
	private EntityManager em;

	
	@Override
	public void save(Authorities auth) {
		// TODO Auto-generated method stub
		this.em.persist(auth);
	}


	@Override
	public void delete(Authorities auth) {
		// TODO Auto-generated method stub
		this.em.detach(auth);
	}

}

