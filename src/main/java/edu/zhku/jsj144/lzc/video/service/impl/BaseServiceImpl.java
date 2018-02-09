package edu.zhku.jsj144.lzc.video.service.impl;

import java.util.List;
import edu.zhku.jsj144.lzc.video.mapper.BaseMapper;
import edu.zhku.jsj144.lzc.video.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseMapper<T> mapper;

	@Override
	public void create(T entity) {
		// TODO Auto-generated method stub
		System.out.println(entity);
		// mapper.create(entity);
	}

	@Override
	public T get(String id) {
		// TODO Auto-generated method stub
		System.out.println("aa_" + id);
		return null;
	}

	@Override
	public List<T> get(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String id, T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

}