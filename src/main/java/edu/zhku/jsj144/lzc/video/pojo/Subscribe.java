package edu.zhku.jsj144.lzc.video.pojo;

import java.sql.Timestamp;

import javax.ws.rs.PathParam;

public class Subscribe {
	
	@PathParam("id")
	private String id = null;
	private String uid = null;
	private String s_uid = null;
	private Timestamp datetime = null;

}
