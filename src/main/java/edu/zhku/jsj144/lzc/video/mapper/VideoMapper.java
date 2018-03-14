package edu.zhku.jsj144.lzc.video.mapper;

import org.apache.ibatis.annotations.Param;

import edu.zhku.jsj144.lzc.video.pojo.Video;

public interface VideoMapper extends BaseMapper<Video> {

	public Video selectVideoById(String id);

	/**
	 * 查找指定ID的正在上传的视频信息
	 * @param id 视频id
	 * @return 视频信息
	 */
	public Video selectUploadingVideo(String id);

	/**
	 * 修改视频上传状态
	 * @param vid
	 * @param hasUploaded
	 */
	public void updateUploadState(@Param("vid") String vid, @Param("hasUploaded") boolean hasUploaded);

}
