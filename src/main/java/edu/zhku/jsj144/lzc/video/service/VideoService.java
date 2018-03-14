package edu.zhku.jsj144.lzc.video.service;

import javax.jws.WebService;
import javax.ws.rs.Path;

@WebService
@Path("videos")
public interface VideoService {

	public boolean isPreparedToUpload(String vid);
	
	public void setUploadFinished(String vid);
}
