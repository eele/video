package edu.zhku.jsj144.lzc.video.service.impl;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.VideoMapper;
import edu.zhku.jsj144.lzc.video.pojo.IDInfo;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.service.VideoService;

@Service("videoService")
public class VideoServiceImpl extends BaseServiceImpl<Video, VideoMapper> implements VideoService {

	@Override
	public IDInfo create(Video entity) throws Exception {
		IDInfo info = super.create(entity);
		
		// 通知上传服务器将视频加入上传列表
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client dynamicClient = clientFactory.createClient("http://localhost:8088/service/uploadInfo?wsdl");
		dynamicClient.invoke("addVID", info.getId());
		return info;
	}
}
