package edu.zhku.jsj144.lzc.video.pojo;

import java.util.Date;

import javax.ws.rs.PathParam;

public class Favorite {
	
	@PathParam("id")
	private String id = null;
	private String uid = null;
	private String vid = null;
	private Date datetime = null;

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

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
