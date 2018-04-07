package edu.zhku.jsj144.lzc.video.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.zhku.jsj144.lzc.video.pojo.Admin;
import edu.zhku.jsj144.lzc.video.pojo.SessionInfo;
import edu.zhku.jsj144.lzc.video.pojo.User;

@Path("sessions")
@Produces(MediaType.APPLICATION_JSON)
public interface SessionService {

	@POST
	public SessionInfo create(@BeanParam User user);

	@POST
	@Path("/admin")
	public SessionInfo createByAdmin(@BeanParam Admin admin);
}
