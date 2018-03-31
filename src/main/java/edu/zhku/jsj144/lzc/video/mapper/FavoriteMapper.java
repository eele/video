package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.Favorite;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper extends BaseMapper<Favorite> {

    public String selectFavoriteID(@Param("uid") String uid, @Param("vid") String vid);

    public List<Video> selectFavoriteVideos(@Param("uid") String uid, @Param("pstart") int pstart, @Param("psize") int psize);
}
