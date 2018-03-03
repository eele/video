package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.Video;

public interface VideoMapper extends BaseMapper<Video> {

	public Video selectVideoById(String id);

}
