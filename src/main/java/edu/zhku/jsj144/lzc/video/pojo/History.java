package edu.zhku.jsj144.lzc.video.pojo;

import java.util.Date;

import javax.ws.rs.PathParam;

public class History {
	
	@PathParam("id")
	private String id = null;
	private String uid = null;
	private String vid = null;
	private Date datetime = null;

}
