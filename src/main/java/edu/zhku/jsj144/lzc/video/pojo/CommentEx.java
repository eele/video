package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.PathParam;
import java.sql.Timestamp;

public class CommentEx {
	
	@PathParam("id")
	private String id = null;
	private String vid = null;
	private String uid = null;
	private String username = null;
	private String text = null;
	private Timestamp datetime = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
