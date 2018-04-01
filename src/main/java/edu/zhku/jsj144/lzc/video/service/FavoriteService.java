package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import edu.zhku.jsj144.lzc.video.pojo.Video;

import javax.ws.rs.*;
import java.util.List;

@Path("favorites")
public interface FavoriteService {

    @GET
    public String getFavoriteID(@QueryParam("uid") String uid, @QueryParam("vid") String vid);

    @GET
    @Path("/videos")
    public List<Video> getFavoriteVideos(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @DELETE
    @RequireToken
    public void deleteFavoriteVideo(@FormParam("uid") String uid, @FormParam("vid") String vid);
}
