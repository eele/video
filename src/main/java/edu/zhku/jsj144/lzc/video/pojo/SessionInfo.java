package edu.zhku.jsj144.lzc.video.pojo;

/**
 * 认证结果信息实体类
 * 
 * @author ele
 *
 */
public class SessionInfo {

	private String uid;
	private String token;
	private String stateMsg;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStateMsg() {
		return stateMsg;
	}

	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

}
