package edu.zhku.jsj144.lzc.video.pojo;

/**
 * id号信息实体类
 * @author ele
 *
 */
public class IDInfo {
	
	private String id;
	private String token;

	public IDInfo(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
