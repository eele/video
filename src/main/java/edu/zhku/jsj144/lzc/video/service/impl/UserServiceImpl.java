package edu.zhku.jsj144.lzc.video.service.impl;

import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.UserMapper;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {
	
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return super.mapper.selectUserByName(username);
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return super.mapper.selectUserById(id);
	}

}
