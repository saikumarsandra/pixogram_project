package com.cts.training.Blockservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="blockeduser")
public class BlockedUser {
		
	
	@Id
	private Integer userId;
	@Column
	private Integer blockedUserId;
	
	public BlockedUser() {
		// TODO Auto-generated constructor stub
	}
	
	public BlockedUser(Integer userId, Integer blockedUserId) {
		
		this.userId = userId;
		this.blockedUserId = blockedUserId;
	}
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBlockedUserId() {
		return blockedUserId;
	}
	public void setBlockedUserId(Integer blockedUserId) {
		this.blockedUserId = blockedUserId;
	}

	@Override
	public String toString() {
		return "BlockedUser [userId=" + userId + ", blockedUserId=" + blockedUserId + "]";
	}

	

}
