package edu.zhku.jsj144.lzc.video.service.impl;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import edu.zhku.jsj144.lzc.video.pojo.User;

@Path("user")
@Component("userService")
public class UserServiceImpl extends BaseServiceImpl<User> {

}
