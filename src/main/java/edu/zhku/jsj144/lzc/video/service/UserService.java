package edu.zhku.jsj144.lzc.video.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import edu.zhku.jsj144.lzc.video.pojo.Admin;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import java.io.IOException;
import java.util.List;

@Path("users")
public interface UserService {

    @PUT
    @Path("/{id}/info")
    @RequireToken(ownResourceOnly = true)
    public void updateInfo(@BeanParam User user);

	@GET
	@Path("/{id}")
	public User getUserById(@PathParam("id") String id);

    @GET
    @RequireToken
    @Path("/admin/{id}")
    public Admin getAdminById(@PathParam("id") String id);

    @GET
    public List<UserEx> getUsers(@QueryParam("mineId") String mineId, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/all/found")
    public List<UserEx> searchUsers(@QueryParam("username") String username, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @PUT
    @Path("/{id}/password")
    @RequireToken(ownResourceOnly = true)
    public void changePassword(@PathParam("id") String id, @FormParam("pwd") String pwd);

    @PUT
    @Path("/admin/{id}/password")
    @RequireToken(ownResourceOnly = true)
    public void changeAdminPassword(@PathParam("id") String id, @FormParam("pwd") String pwd);

    @DELETE
    @Path("/{id}/alldata")
    @RequireToken(ownResourceOnly = true)
    public void deleteAllData(@BeanParam User user);

    /**
     * 上传用户头像
     * @param id
     * @param image
     */
    @POST
    @Path("/{id}/portrait")
    @Consumes("multipart/form-data")
    @RequireToken(ownResourceOnly = true)
    public void uploadPortrait(@PathParam("id") String id, @Multipart(value="file",type="image/jpeg")Attachment image) throws IOException;

    /**
     * 获取用户头像
     * @param id
     * @return
     */
    @GET
    @Path("/{id}/portrait")
    @Produces("image/jpeg")
    public Response getPortrait(@PathParam("id") String id);
}
