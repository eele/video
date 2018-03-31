package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.mapper.FavoriteMapper;
import edu.zhku.jsj144.lzc.video.pojo.Favorite;
import edu.zhku.jsj144.lzc.video.pojo.Video;
import edu.zhku.jsj144.lzc.video.service.FavoriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("favoriteService")
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, FavoriteMapper> implements FavoriteService {

    @Override
    public String getFavoriteID(String uid, String vid) {
        return super.mapper.selectFavoriteID(uid, vid);
    }

    @Override
    public List<Video> getFavoriteVideos(String uid, int pstart, int psize) {
        return super.mapper.selectFavoriteVideos(uid, pstart, psize);
    }
}
