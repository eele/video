package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

public class User {
	@PathParam("id")
	private String id;
	@FormParam("username")
	private String username;
	@FormParam("password")
	private String password = "";
	@FormParam("description")
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
