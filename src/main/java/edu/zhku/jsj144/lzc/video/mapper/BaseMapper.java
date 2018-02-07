package edu.zhku.jsj144.lzc.video.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

	public void create(T entity);
	
	public T read(String id);
	
	public List<T> get(T entity, Map<String, Object> data);

	public void update(T entity);

	public void delete(T entity);
}
