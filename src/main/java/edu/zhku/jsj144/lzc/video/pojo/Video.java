package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.QueryParam;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
public class Video {
	@QueryParam("id")
	private String id; // 视频ID
	@QueryParam("title")
	private String title; // 视频标题
	@QueryParam("uid")
	private String uid; // 用户ID
	@QueryParam("cid")
	private String cid; // 类别ID
	@QueryParam("pid")
	private String pid; // 播单ID

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", uid=" + uid + ", cid=" + cid + ", pid=" + pid + "]";
	}

}
