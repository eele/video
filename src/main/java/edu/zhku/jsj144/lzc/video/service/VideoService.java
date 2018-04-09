package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.pojo.VideoEx;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.*;
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

    @WebMethod
    public void setUploadFinished(String vid);

	@GET
    @Path("/p/v")
    @RequireToken
	public void verifyToken();

    @GET
    @Path("/p/uploaded")
    public List<Video> getUploadedVideosByUID(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/p/reviewed")
    @RequireToken
    public List<VideoEx> getReviewedVideos(@QueryParam("uid") String uid, @QueryParam("title") String title,
                                           @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/p/unreviewed")
    @RequireToken
    public List<VideoEx> getUnreviewedVideos(@QueryParam("uid") String uid, @QueryParam("title") String title,
                                             @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    public List<Video> getVideosByCID(@QueryParam("cid") String cid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/{id}")
    public Video getOneVideo(@PathParam("id") String id);

    @GET
    @Path("/all/found")
    public List<Video> searchVideos(@QueryParam("title") String title, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @PUT
    @Path("/{id}/review")
    public void setReviewPass(@PathParam("id") String id, @FormParam("result") boolean result);
}
