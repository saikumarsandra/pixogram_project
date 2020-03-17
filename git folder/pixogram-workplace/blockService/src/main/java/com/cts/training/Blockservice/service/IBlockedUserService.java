package com.cts.training.Blockservice.service;

import java.util.List;

import com.cts.training.Blockservice.entity.BlockedUser;



public interface IBlockedUserService {

	List<BlockedUser> findAllBlockedUser();
	BlockedUser findBlockedUserById(Integer id);
	boolean addBlockedUser(BlockedUser BlockedUser);
	boolean updateBlockedUser(BlockedUser BlockedUser);
	boolean deleteBlockedUser(Integer id);
}
