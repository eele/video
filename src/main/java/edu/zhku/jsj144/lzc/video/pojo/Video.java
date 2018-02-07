package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.FormParam;

public class Video {
	@FormParam("id")
	private String id; // 视频ID
	@FormParam("title")
	private String title; // 视频标题
	@FormParam("uid")
	private String uid; // 用户ID
	@FormParam("cid")
	private String cid; // 类别ID
	@FormParam("pid")
	private String pid; // 播单ID

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", uid=" + uid + ", cid=" + cid + ", pid=" + pid + "]";
	}

}
