package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.mapper.*;
import edu.zhku.jsj144.lzc.video.pojo.Admin;
import edu.zhku.jsj144.lzc.video.pojo.IDInfo;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;
import edu.zhku.jsj144.lzc.video.service.UserService;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private SubscribeMapper subscribeMapper;
    @Autowired
    private VideoMapper videoMapper;

//    private WebServiceContext context;

    private String portraitPath = "/usr/local/tomcat/portraits";
//
//    @Resource
//    public void setContext(WebServiceContext context) {
//        this.context = context;
//        MessageContext ctx = context.getMessageContext();
//        HttpServletRequest request = (HttpServletRequest) ctx
//                .get(AbstractHTTPDestination.HTTP_REQUEST);
//        portraitPath = request.getParameter("portraitPath");
//    }

    @Override
	public IDInfo create(User entity) throws Exception {
		// TODO Auto-generated method stub
		String uid = UUID.randomUUID().toString().replace("-", "");

		Method setId = entity.getClass().getMethod("setId", String.class);
		setId.invoke(entity, uid);

		mapper.create(entity);
		return new IDInfo(uid);
	}

    @Override
    public void updateInfo(User user) {
        mapper.updateInfo(user.getId(), user.getUsername(), user.getDescription());
    }

    @Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectUserById(id);
	}

    @Override
    public Admin getAdminById(String id) {
        return mapper.selectAdminById(id);
    }

    @Override
	public List<UserEx> getUsers(String mineId, int pstart, int psize) {
		if (mineId.equals("all")) {
			return mapper.selectUsers(pstart, psize);
		} else {
			return mapper.selectUsersByUID(mineId, pstart, psize);
		}
	}

    @Override
    public List<UserEx> searchUsers(String username, int pstart, int psize) {
        return mapper.selectUsersByUsername("%" + username + "%", pstart, psize);
    }

    @Override
    public void changePassword(String id, String pwd) {
        mapper.updatePassword(id, pwd);
    }

    @Override
    public void changeAdminPassword(String id, String pwd) {
        mapper.updateAdminPassword(id, pwd);
    }

    @Override
    public void deleteAllData(User user) {
        commentMapper.deleteByUID(user.getId());
        favoriteMapper.deleteByUID(user.getId());
        subscribeMapper.deleteByUID(user.getId());
        videoMapper.deleteByUID(user.getId());
        mapper.delete(user);
    }

    @Override
    public void uploadPortrait(String id, Attachment image) throws IOException {
        InputStream ins = image.getDataHandler().getInputStream();
        writeToFile(ins, portraitPath + "/" + id);
    }

    @Override
    public Response getPortrait(String id) {
        File file = new File(portraitPath + "/" + id);
        if (file.exists()) {
            Response.ResponseBuilder response = Response.ok(file);
            response.header("Content-Disposition", "attachment;filename='img'");
            return response.build();
        } else {
            return Response.ok("").build();
        }
    }

    private void writeToFile(InputStream ins, String path) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(path));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = ins.read(bytes)) != -1) {
                out.write(bytes,0, read);
            }
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
