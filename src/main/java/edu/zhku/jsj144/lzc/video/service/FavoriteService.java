package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.pojo.Video;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("favorites")
public interface FavoriteService {

    @GET
    public String getFavoriteID(@QueryParam("uid") String uid, @QueryParam("vid") String vid);

    @GET
    @Path("/videos")
    public List<Video> getFavoriteVideos(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);
}
