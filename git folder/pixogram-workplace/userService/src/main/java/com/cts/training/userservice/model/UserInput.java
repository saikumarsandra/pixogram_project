package com.cts.training.userservice.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
	
	private String username;
	private String email;
	private String password;

	private String profile;
	
}
