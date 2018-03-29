package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.pojo.IDInfo;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.UserMapper;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.service.UserService;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

	@Override
	public IDInfo create(User entity) throws Exception {
		// TODO Auto-generated method stub
		String uid = UUID.randomUUID().toString().replace("-", "");

		Method setId = entity.getClass().getMethod("setId", String.class);
		setId.invoke(entity, uid);

		super.mapper.create(entity);
		return new IDInfo(uid);
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return super.mapper.selectUserById(id);
	}

	@Override
	public List<UserEx> getUsers(String mineId, int pstart, int psize) {
		if (mineId.equals("all")) {
			return super.mapper.selectUsers(pstart, psize);
		} else {
			return super.mapper.selectUsersByUID(mineId, pstart, psize);
		}
	}

}
