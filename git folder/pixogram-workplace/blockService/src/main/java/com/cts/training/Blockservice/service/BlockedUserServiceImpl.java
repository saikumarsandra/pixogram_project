package com.cts.training.Blockservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.training.Blockservice.entity.BlockedUser;
import com.cts.training.Blockservice.repository.BlockedUserRepository;





// @Component
@Service
public class BlockedUserServiceImpl implements IBlockedUserService {

	@Autowired
	private BlockedUserRepository blockedUserRepository;
	
	
	
	// get all
	@Override
	public List<BlockedUser> findAllBlockedUser() {
		// add additional logic
		return this.blockedUserRepository.findAll();
	}

	
	
	/// by id
	@Override
	public BlockedUser findBlockedUserById(Integer id) {
		// TODO Auto-generated method stub
		// resolves problem of null reference exception
		Optional<BlockedUser> record =  this.blockedUserRepository.findById(id);
		// reduces the chance of NullException
		
		// can check if object is there
		BlockedUser blockedUser = new BlockedUser();
		if(record.isPresent())
			blockedUser = record.get();
		return blockedUser;
		
	}
	
	
	
	@Override
	public boolean addBlockedUser(BlockedUser blockedUser) {
		// TODO Auto-generated method stub
		this.blockedUserRepository.save(blockedUser);
		return true;
	}
	
	
	@Override
	public boolean updateBlockedUser(BlockedUser blockedUser) {
		// TODO Auto-generated method stub
		this.blockedUserRepository.save(blockedUser);
		return true;
	}

	@Override
	public boolean deleteBlockedUser(Integer id) {
		// TODO Auto-generated method stub
		this.blockedUserRepository.deleteById(id);
		return true;
	}
	
	


	
	
}
