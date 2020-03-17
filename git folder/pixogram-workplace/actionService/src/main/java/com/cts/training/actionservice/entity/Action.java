package com.cts.training.actionservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import antlr.collections.List;
@Entity
@Table(name="actions")
public class Action {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer mediaId;
	@Column
	private Integer userId;
	@Column
	private Boolean status;
	@Column
	@CreationTimestamp
	private LocalDateTime createdOn;
	

	
	public Action() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Action(Integer id, Integer mediaId, Integer userId, Boolean status, LocalDateTime createdOn) {
		
		this.id = id;
		this.mediaId = mediaId;
		this.userId = userId;
		this.status = status;
		this.createdOn = createdOn;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMediaId() {
		return mediaId;
	}
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Actions [id=" + id + ", mediaId=" + mediaId + ", userId=" + userId + ", status=" + status
				+ ", createdOn=" + createdOn + "]";
	}
	

}



