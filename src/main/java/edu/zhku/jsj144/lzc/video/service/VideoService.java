package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.pojo.Video;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@WebService
@Path("videos")
public interface VideoService {

	public boolean isPreparedToUpload(String vid);
	
	public void setUploadFinished(String vid);

	@GET
    @Path("/uploading")
	public List<Video> getUploadingVideosByUID(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    @Path("/uploaded")
    public List<Video> getUploadedVideosByUID(@QueryParam("uid") String uid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);

    @GET
    public List<Video> getVideosByCID(@QueryParam("cid") String cid, @QueryParam("pstart") int pstart, @QueryParam("psize") int psize);
}
