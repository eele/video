package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

	public User selectUserByName(String username);
	
	public User selectUserById(String id);

	public List<UserEx> selectUsers(@Param("pstart") int pstart, @Param("psize") int psize);

	public List<UserEx> selectUsersByUID(@Param("mineId") String mineId, @Param("pstart") int pstart, @Param("psize") int psize);
}
