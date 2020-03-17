package com.pixogram.mediaplumbing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MediaDetails {

	private Integer id;
	private Integer userid;
	private String url;
	private String title;
	private String description;
	private String tags;
	private String type;
	
	
}
