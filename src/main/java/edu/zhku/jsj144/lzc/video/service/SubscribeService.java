package edu.zhku.jsj144.lzc.video.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("subscribe")
public interface SubscribeService {

    @GET
    public String getSubscribeID(@QueryParam("uid") String uid, @QueryParam("s_uid") String s_uid);
}
