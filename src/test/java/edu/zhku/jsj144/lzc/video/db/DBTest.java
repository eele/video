package edu.zhku.jsj144.lzc.video.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.zhku.jsj144.lzc.video.mapper.BaseMapper;
import edu.zhku.jsj144.lzc.video.pojo.Video;

public class DBTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			@SuppressWarnings("unchecked")
			BaseMapper<Video> mapper = session.getMapper(BaseMapper.class);
			mapper.create(new Video());;
		} finally {
			session.close();
		}
	}

}
