package com.cts.training.userservice.repository;


import com.cts.training.userservice.entity.Authorities;

public interface RolesRepository{
	
	public void save(Authorities auth);


	public void delete(Authorities auth);
}
