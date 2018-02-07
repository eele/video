package edu.zhku.jsj144.lzc.video.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Echo {
	private String state;
	private Object data;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
