package com.mysite.sbb.etc;

import lombok.Data;

@Data
public class User1 {
	private String username;
	private int age;
	
	public User1(String username, int age) {
		super();
		this.username = username;
		this.age = age;
	}
}
