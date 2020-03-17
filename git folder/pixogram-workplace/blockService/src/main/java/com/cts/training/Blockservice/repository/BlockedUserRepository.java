package com.cts.training.Blockservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.training.Blockservice.entity.BlockedUser;



@Repository
public interface BlockedUserRepository extends JpaRepository<BlockedUser, Integer>{

}
