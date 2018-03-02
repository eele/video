package edu.zhku.jsj144.lzc.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.UserMapper;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user = mapper.selectUser(username);
		user.setPassword("");
		return user;
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = mapper.selectUserById(id);
		user.setPassword("");
		return user;
	}

}
