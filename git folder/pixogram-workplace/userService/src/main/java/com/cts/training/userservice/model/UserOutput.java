package com.cts.training.userservice.model;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserOutput {
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String profile;

}
