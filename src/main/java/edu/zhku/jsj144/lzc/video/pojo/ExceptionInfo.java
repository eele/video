package edu.zhku.jsj144.lzc.video.pojo;

import java.util.Date;

import javax.ws.rs.core.Response;
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
	private Response.Status httpStatus;

	public ExceptionInfo status(String status) {
		this.status = status;
		return this;
	}
	
	public ExceptionInfo msg(String msg) {
		this.msg = msg;
		return this;
	}

    public ExceptionInfo httpStatus(Response.Status httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public Response.Status getHttpStatus() {
        return httpStatus;
    }

    @XmlElement
	public Date getDatetime() {
		return new Date();
	}

}
