package edu.zhku.jsj144.lzc.video.pojo;

import java.sql.Timestamp;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

public class Favorite {
	
	@PathParam("id")
	private String id = null;
	@FormParam("uid")
	private String uid = null;
	@FormParam("vid")
	private String vid = null;
	private Timestamp datetime = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
