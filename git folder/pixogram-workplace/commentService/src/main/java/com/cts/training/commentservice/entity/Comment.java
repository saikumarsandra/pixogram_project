 package com.cts.training.commentservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="comment")
public class Comment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column
		private Integer mediaId;
		@Column
		private Integer userId;
		@Column
		private String comments;
		@Column
		@CreationTimestamp
		private LocalDateTime createdOn;
		
		
		
		public Comment() {
		// TODO Auto-generated constructor stub
		}
		
		public Comment(Integer id, Integer mediaId, Integer userId, String comments, LocalDateTime createdOn) {
			
			this.id = id;
			this.mediaId = mediaId;
			this.userId = userId;
			this.comments = comments;
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
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		public LocalDateTime getCreatedOn() {
			return createdOn;
		}
		public void setCreatedOn(LocalDateTime createdOn) {
			this.createdOn = createdOn;
		}
		
		@Override
		public String toString() {
			return "Comments [id=" + id + ", mediaId=" + mediaId + ", userId=" + userId + ", comments=" + comments
					+ ", createdOn=" + createdOn + "]";
		}
		
		}



