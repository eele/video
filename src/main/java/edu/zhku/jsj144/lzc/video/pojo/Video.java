package edu.zhku.jsj144.lzc.video.pojo;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
public class Video {

	@PathParam("id")
	private String id; // 视频ID
	@QueryParam("title")
	private String title; // 视频标题
	@QueryParam("uid")
	private String uid; // 用户ID
	@QueryParam("cid")
	private String cid; // 类别ID
	@QueryParam("pid")
	private String pid; // 播单ID

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", uid=" + uid + ", cid=" + cid + ", pid=" + pid + "]";
	}

}
