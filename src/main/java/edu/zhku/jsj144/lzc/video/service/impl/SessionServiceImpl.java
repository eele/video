package edu.zhku.jsj144.lzc.video.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.UserMapper;
import edu.zhku.jsj144.lzc.video.pojo.SessionInfo;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.service.SessionService;
import edu.zhku.jsj144.lzc.video.util.TokenUtil;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	private UserMapper mapper;
	private final long TOKENTTL = 100000; // 令牌过期时间
	
	@Override
	public SessionInfo create(User user) {
		SessionInfo info = new SessionInfo();
		User retUser = mapper.selectUserByName(user.getUsername());
		if (retUser == null) {
			info.setStateMsg("用户不存在");
		} else {
			if (retUser.getPassword().equals(user.getPassword())) {
				info.setStateMsg("OK");
				info.setUid(retUser.getId());
				info.setToken(TokenUtil.createToken(TOKENTTL));
			} else {
				info.setStateMsg("密码错误");
			}
		}
		return info;
	}
	
}
