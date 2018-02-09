package edu.zhku.jsj144.lzc.video.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zhku.jsj144.lzc.video.mapper.BaseMapper;
import edu.zhku.jsj144.lzc.video.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> mapper;

	@Override
	public void create(T entity) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Method setter = entity.getClass().getMethod("setId", String.class);
		setter.invoke(entity, UUID.randomUUID().toString());
		mapper.create(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		mapper.update(entity);
	}

	@Override
	public void deleteByID(T entity) {
		// TODO Auto-generated method stub
		mapper.delete(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		mapper.delete(entity);
	}

}