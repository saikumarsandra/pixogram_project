package com.cts.training.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.training.userservice.entity.Authorities;
import com.cts.training.userservice.repository.RolesRepository;


@Service
public class RolesService {
	
	@Autowired
	private RolesRepository roleRepository;
	
	public void saveauthority(Authorities role) {
		this.roleRepository.save(role);
	}

}
