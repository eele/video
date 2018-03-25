package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.Comment;
import edu.zhku.jsj144.lzc.video.pojo.CommentEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper extends BaseMapper<Comment> {

    public List<CommentEx> selectCommentsByVID(@Param("vid") String vid, @Param("pstart") int pstart, @Param("psize") int psize);
}
