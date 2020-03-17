package com.cts.training.userservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
// @Table(name = "authorities",uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
@Table(name = "authorities") // ,uniqueConstraints = @UniqueConstraint(columnNames = {"username", "authority"}))
public class Authorities implements Serializable{
	

	@Id
	@Column(name = "username",length=100)
	private String username;
	
	@Id
	@Column(name = "authority",length=100)
	private String authority; ;
	
}