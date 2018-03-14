package edu.zhku.jsj144.lzc.video.service.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.VideoMapper;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.service.VideoService;

@WebService(
		endpointInterface = "edu.zhku.jsj144.lzc.video.service.VideoService", 
		targetNamespace="http://service.video.lzc.jsj144.zhku.edu/",
		serviceName = "VideoService")
@Service("videoService")
public class VideoServiceImpl extends BaseServiceImpl<Video, VideoMapper> implements VideoService {

	@Override
	public boolean isPreparedToUpload(String vid) {
		return super.mapper.selectUploadingVideo(vid) != null;
	}

	@Override
	public void setUploadFinished(String vid) {
		super.mapper.updateUploadState(vid, true);
	}

}
