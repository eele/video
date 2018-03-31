package edu.zhku.jsj144.lzc.video.pojo;

import java.sql.Timestamp;

import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;

public class Subscribe {
	
	@PathParam("id")
	private String id = null;
	@FormParam("uid")
	private String uid = null;
	@FormParam("s_uid")
	private String s_uid = null;
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

	public String getS_uid() {
		return s_uid;
	}

	public void setS_uid(String s_uid) {
		this.s_uid = s_uid;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
}
