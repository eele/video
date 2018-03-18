package edu.zhku.jsj144.lzc.video.mapper;

import org.apache.ibatis.annotations.Param;

import edu.zhku.jsj144.lzc.video.pojo.Video;

import java.util.List;

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

	/**
	 * 查询某用户正在上传的视频
	 * @param uid
	 * @return
	 */
	public List<Video> selectUploadingVideosByUID(@Param("uid") String uid, @Param("pstart") int pstart, @Param("psize") int psize);

	/**
	 * 查询某用户已上传视频
	 * @param uid
	 * @return
	 */
	public List<Video> selectUploadedVideosByUID(@Param("uid") String uid, @Param("pstart") int pstart, @Param("psize") int psize);
}
