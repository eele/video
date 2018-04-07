package edu.zhku.jsj144.lzc.video.service.impl;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zhku.jsj144.lzc.video.mapper.BaseMapper;
import edu.zhku.jsj144.lzc.video.pojo.IDInfo;
import edu.zhku.jsj144.lzc.video.service.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<enT, mapperT> implements BaseService<enT, mapperT> {

	@Autowired
	protected mapperT mapper;

	@Override
	public IDInfo create(enT entity) throws Exception {
		// TODO Auto-generated method stub
		String eid = UUID.randomUUID().toString().replace("-", "");
        String uid = "";
        try {
            Method getUid = entity.getClass().getMethod("getUid");
            uid = (String) getUid.invoke(entity);
		} catch (NoSuchMethodException e) {

		}

        try {
            Method setDatetime = entity.getClass().getMethod("setDatetime", Timestamp.class);
            setDatetime.invoke(entity, new Timestamp(System.currentTimeMillis()));
        } catch (NoSuchMethodException e) {

        }
		Method setId = entity.getClass().getMethod("setId", String.class);
		setId.invoke(entity, uid + eid);
		((BaseMapper<enT>) mapper).create(entity);
		return new IDInfo(uid + eid);
	}

	@Override
	public void update(enT entity) {
		// TODO Auto-generated method stub
		((BaseMapper<enT>) mapper).update(entity);
	}

	@Override
	public void deleteByID(enT entity) {
		// TODO Auto-generated method stub
		((BaseMapper<enT>) mapper).delete(entity);
	}

}