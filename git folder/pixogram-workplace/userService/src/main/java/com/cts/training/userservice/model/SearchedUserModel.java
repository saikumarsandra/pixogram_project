package com.cts.training.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchedUserModel {
	private Integer userId;
	private String  username;
	private String profile;
	private Boolean followed;
}
