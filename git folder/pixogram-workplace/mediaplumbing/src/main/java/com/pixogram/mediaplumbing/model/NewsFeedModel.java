package com.pixogram.mediaplumbing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsFeedModel {
	private Integer userId;
	private String feed;
	private String CreatedOn;
	

}
