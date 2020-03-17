package com.pixogram.mediaservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MediaData {
		
	private Integer id;
	private Integer userid;
	private String url;
	private String title;
	private String description;
	private String tags;
	private String type;
	
	
}
