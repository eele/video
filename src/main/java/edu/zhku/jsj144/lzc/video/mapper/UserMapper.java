package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.User;

public interface UserMapper {

	public User selectUser(String username);
	
	public User selectUserById(String id);

}
