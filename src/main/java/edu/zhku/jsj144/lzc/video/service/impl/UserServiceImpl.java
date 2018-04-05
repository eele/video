package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.pojo.IDInfo;
import edu.zhku.jsj144.lzc.video.pojo.UserEx;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

import edu.zhku.jsj144.lzc.video.mapper.UserMapper;
import edu.zhku.jsj144.lzc.video.pojo.User;
import edu.zhku.jsj144.lzc.video.service.UserService;

import javax.ws.rs.core.Response;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;
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

    @Override
    public List<UserEx> searchUsers(String username, int pstart, int psize) {
        return mapper.selectUsersByUsername("%" + username + "%", pstart, psize);
    }

    @Override
    public void uploadPortrait(String id, Attachment image) throws IOException {
        InputStream ins = image.getDataHandler().getInputStream();
        writeToFile(ins, "d:/" + id);
    }

    @Override
    public Response getPortrait(String id) {
        File file = new File("d:/" + id);
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
