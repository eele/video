package edu.zhku.jsj144.lzc.video.service.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.VideoMapper;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.service.VideoService;

import java.util.List;

@WebService(
		endpointInterface = "edu.zhku.jsj144.lzc.video.service.VideoService", 
		targetNamespace="http://service.video.lzc.jsj144.zhku.edu/",
		serviceName = "VideoService")
@Service("videoService")
public class VideoServiceImpl extends BaseServiceImpl<Video, VideoMapper> implements VideoService {

	@Override
	public boolean isPreparedToUpload(String vid) {
		return super.mapper.selectVideo(vid) != null;
	}

	@Override
	public void setUploadFinished(String vid) {
		super.mapper.updateUploadState(vid, true);
	}

	@Override
	public List<Video> getUploadingVideosByUID(String uid, int pstart, int psize) {
		return super.mapper.selectUploadingVideosByUID(uid, pstart, psize);
	}

	@Override
	public List<Video> getUploadedVideosByUID(String uid, int pstart, int psize) {
		return super.mapper.selectUploadedVideosByUID(uid, pstart, psize);
	}

	@Override
	public List<Video> getVideosByCID(String cid, int pstart, int psize) {
		return super.mapper.selectVideosByCID(cid, pstart, psize);
	}

    @Override
    public Video getOneVideo(String id) {
        return super.mapper.selectVideo(id);
    }

    @Override
    public List<Video> searchVideos(String title, int pstart, int psize) {
        return mapper.selectVideosByTitle("%" + title + "%", pstart, psize);
    }


}
