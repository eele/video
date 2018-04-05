package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import edu.zhku.jsj144.lzc.video.pojo.Video;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;

@WebService
@Path("videos")
public interface VideoService {

    /**
     * 验证Token，Token合法则返回视频ID给上传服务器
     * @param token
     * @return
     */
    @WebMethod
	public String checkToken(String token);

	@GET
    @Path("/p/v")
    @RequireToken
	public void verifyToken();

    @GET
    @Path("/p/uploaded")
    public List<Video> getUploadedVideosByUID(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    public List<Video> getVideosByCID(@QueryParam("cid") String cid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/{id}")
    public Video getOneVideo(@PathParam("id") String id);

    @GET
    @Path("/all/found")
    public List<Video> searchVideos(@QueryParam("title") String title, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);
}
