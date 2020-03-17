package com.pixogram.mediaplumbing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ActionModel {
	 private Integer id;
		private Integer userid;
		private String url;
		private String title;
		private String description;
		private String tags;
		private String type;
		private Integer comments;
		private Integer likes;
		private Integer disLikes;
			
		

	

}
