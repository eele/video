package edu.zhku.jsj144.lzc.video.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties("hibernateLazyInitializer")
public class ExceptionInfo {
	@XmlElement
	private String status;
	@XmlElement
	private String msg;

	public ExceptionInfo status(String status) {
		this.status = status;
		return this;
	}
	
	public ExceptionInfo msg(String msg) {
		this.msg = msg;
		return this;
	}

	@XmlElement
	public Date getDatetime() {
		return new Date();
	}

}
