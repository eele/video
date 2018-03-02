package edu.zhku.jsj144.lzc.video.pojo;

import java.util.Date;
import java.util.List;

import javax.ws.rs.PathParam;

public class Playlist {
	
	@PathParam("id")
	private String id = null;
	private String uid = null;
	private String title = null;
	private String description = null;
	private Date datetime = null;
	private List<Video> videos = null;

}
