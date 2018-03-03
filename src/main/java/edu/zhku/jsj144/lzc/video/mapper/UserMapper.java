package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.User;

public interface UserMapper extends BaseMapper<User> {

	public User selectUser(String username);
	
	public User selectUserById(String id);

}
