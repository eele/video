package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

public class Admin {
	@PathParam("id")
	private String id;
	@FormParam("username")
	private String username;
	@FormParam("password")
	private String password = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
