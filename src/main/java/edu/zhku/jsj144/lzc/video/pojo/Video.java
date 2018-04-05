package edu.zhku.jsj144.lzc.video.pojo;

import java.sql.Timestamp;

import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties("hibernateLazyInitializer")
public class Video {

	@PathParam("id")
	private String id; // 视频ID
	@FormParam("title")
	private String title; // 视频标题
	@FormParam("uid")
	private String uid; // 用户ID
	@FormParam("cid")
	private String cid; // 类别ID
	@FormParam("description")
	private String description; // 描述
	@FormParam("permission")
	private Boolean permission = false; // 权限
	private int verify = 0; // 审核验证
	private Timestamp datetime; // 日期

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPermission() {
		return permission;
	}

	public void setPermission(Boolean permission) {
		this.permission = permission;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

}
