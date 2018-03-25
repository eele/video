package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.pojo.CommentEx;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("comments")
public interface CommentService {

    @GET
    public List<CommentEx> getCommentsByVID(@QueryParam("vid") String vid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);
}
