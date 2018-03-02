package edu.zhku.jsj144.lzc.video.pojo;

import java.sql.Timestamp;

import javax.ws.rs.PathParam;

public class Message {
	
	@PathParam("id")
	private String id = null;
	private String uid = null;
	private String cid = null;
	private String sid = null;
	private String fid = null;
	private String text = null;
	private Timestamp datetime = null;

}
