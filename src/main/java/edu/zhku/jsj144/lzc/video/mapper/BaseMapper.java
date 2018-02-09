package edu.zhku.jsj144.lzc.video.mapper;

public interface BaseMapper<T> {

	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);
}
