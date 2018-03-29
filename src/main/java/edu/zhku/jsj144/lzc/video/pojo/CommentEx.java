package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.PathParam;
import java.sql.Timestamp;

public class CommentEx extends Comment {

	private String username = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
