package edu.zhku.jsj144.lzc.video.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;

import java.util.List;

@Path("users")
public interface UserService {

	@GET
	@Path("/{id}")
	public User getUserById(@PathParam("id") String id);

    @GET
    public List<UserEx> getUsers(@QueryParam("mineId") String mineId, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

}
