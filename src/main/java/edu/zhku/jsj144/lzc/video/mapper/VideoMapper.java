package edu.zhku.jsj144.lzc.video.mapper;

import org.apache.ibatis.annotations.Param;

import edu.zhku.jsj144.lzc.video.pojo.Video;

import java.util.List;

public interface VideoMapper extends BaseMapper<Video> {

	/**
	 * 查询某用户已上传视频
	 * @param uid
	 * @return
	 */
	public List<Video> selectUploadedVideosByUID(@Param("uid") String uid, @Param("pstart") int pstart, @Param("psize") int psize);

    /**
     * 按类别查询视频
     * @param cid
     * @param pstart
     * @param psize
     * @return
     */
    public List<Video> selectVideosByCID(@Param("cid") String cid, @Param("pstart") int pstart, @Param("psize") int psize);

	/**
	 * 根据ID获取视频
	 * @param id
	 * @return
	 */
	public Video selectVideo(String id);

	/**
	 * 根据标题搜索视频
	 * @param title
     * @param pstart
     * @param psize
	 * @return
	 */
	public List<Video> selectVideosByTitle(@Param("title") String title, @Param("pstart") int pstart, @Param("psize") int psize);
}
