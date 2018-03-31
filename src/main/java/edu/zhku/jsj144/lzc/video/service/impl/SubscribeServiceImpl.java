package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.mapper.SubscribeMapper;
import edu.zhku.jsj144.lzc.video.pojo.Subscribe;
import edu.zhku.jsj144.lzc.video.service.SubscribeService;
import org.springframework.stereotype.Service;

@Service("subscribeService")
public class SubscribeServiceImpl extends BaseServiceImpl<Subscribe, SubscribeMapper> implements SubscribeService {

    @Override
    public String getSubscribeID(String uid, String s_uid) {
        return super.mapper.selectSubscribeID(uid, s_uid);
    }
}
