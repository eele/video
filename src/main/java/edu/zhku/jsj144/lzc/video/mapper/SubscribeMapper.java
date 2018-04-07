package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.Subscribe;
import org.apache.ibatis.annotations.Param;

public interface SubscribeMapper extends BaseMapper<Subscribe> {

    public String selectSubscribeID(@Param("uid") String uid, @Param("s_uid") String s_uid);

    public void deleteByUID(String uid);
}
