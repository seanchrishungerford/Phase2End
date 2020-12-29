package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {
	@Id
	private String username;

	private String password;

	public Registration(String username, String password) {

		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
