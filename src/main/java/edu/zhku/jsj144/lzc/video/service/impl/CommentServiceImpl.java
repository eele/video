package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.mapper.CommentMapper;
import edu.zhku.jsj144.lzc.video.pojo.Comment;
import edu.zhku.jsj144.lzc.video.pojo.CommentEx;
import edu.zhku.jsj144.lzc.video.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentMapper> implements CommentService {
    @Override
    public List<CommentEx> getCommentsByVID(String vid, int pstart, int psize) {
        return super.mapper.selectCommentsByVID(vid, pstart, psize);
    }
}
