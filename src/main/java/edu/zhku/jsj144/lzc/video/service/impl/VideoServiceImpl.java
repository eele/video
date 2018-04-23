package edu.zhku.jsj144.lzc.video.service.impl;

import javax.jws.WebService;

import edu.zhku.jsj144.lzc.video.pojo.VideoEx;
import edu.zhku.jsj144.lzc.video.util.TokenUtil;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.VideoMapper;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.service.VideoService;

import java.io.File;
import java.util.List;

@WebService(
		endpointInterface = "edu.zhku.jsj144.lzc.video.service.VideoService",
		targetNamespace="http://service.video.lzc.jsj144.zhku.edu/",
		serviceName = "VideoService")
@Service("videoService")
public class VideoServiceImpl extends BaseServiceImpl<Video, VideoMapper> implements VideoService {

    private JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();

    @Override
    public void deleteByID(Video entity) throws Exception {
        super.deleteByID(entity);
        String url = url = "http://localhost:8088/video/service/p?wsdl";
        Client dynamicClient = clientFactory.createClient(url);
        dynamicClient.invoke("deleteVideoFile", entity.getId());
    }

    @Override
	public String checkToken(String token) {
		return TokenUtil.checkToken(token);
	}

    @Override
    public void setUploadFinished(String vid) {
        mapper.updateReviewWaiting(vid);
    }

    @Override
    public void verifyToken() {

    }

    @Override
	public List<Video> getUploadedVideosByUID(String uid, int pstart, int psize) {
		return mapper.selectUploadedVideosByUID(uid, pstart, psize);
	}

    @Override
    public List<VideoEx> getReviewedVideos(String uid, String title, int pstart, int psize) {
        List<VideoEx> videoExList =  mapper.selectReviewedVideos("%" + uid + "%", "%" + title + "%", pstart, psize);
        videoExList.get(0).setNum(mapper.selectReviewedVideoNum("%" + uid + "%", "%" + title + "%"));
        return videoExList;
    }

    @Override
    public List<VideoEx> getUnreviewedVideos(String uid, String title, int pstart, int psize) {
        List<VideoEx> videoExList =  mapper.selectUnreviewedVideos("%" + uid + "%", "%" + title + "%", pstart, psize);
        videoExList.get(0).setNum(mapper.selectUnreviewedVideoNum("%" + uid + "%", "%" + title + "%"));
        return videoExList;
    }

    @Override
	public List<Video> getVideosByCID(String cid, int pstart, int psize) {
		return mapper.selectVideosByCID(cid, pstart, psize);
	}

    @Override
    public Video getOneVideo(String id) {
        return mapper.selectVideo(id);
    }

    @Override
    public List<Video> searchVideos(String title, int pstart, int psize) {
        return mapper.selectVideosByTitle("%" + title + "%", pstart, psize);
    }

    @Override
    public void setReviewPass(String id, boolean result) {
	    if (result) {
            mapper.updateReviewPass(id);
        } else {
            mapper.updateReviewNoPass(id);
        }
    }

}
