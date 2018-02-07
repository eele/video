package edu.zhku.jsj144.lzc.video.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import edu.zhku.jsj144.lzc.video.mapper.BaseMapper;
import edu.zhku.jsj144.lzc.video.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

	private BaseMapper<T> mapper;

	private Class<?> eClass;

	public BaseServiceImpl() {
		// 获取传入泛型参数T的具体类
		Class<?> c = this.getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.eClass = (Class<?>) p[0];
		}

		// 修改Path注解URL参数
		try {
			Path createPathAnno = BaseService.class.getAnnotation(Path.class);
			InvocationHandler handler = Proxy.getInvocationHandler(createPathAnno);
			Field hField = handler.getClass().getDeclaredField("memberValues");
			hField.setAccessible(true);
			@SuppressWarnings("unchecked")
			Map<String, String> memberValues = (Map<String, String>) hField.get(handler);
			StringBuilder sb = new StringBuilder(eClass.getSimpleName());
			sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
			memberValues.put("value", createPathAnno.value().replaceAll("_\\$base", sb.toString()));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

//	@SuppressWarnings("unchecked")
//	protected T mapToEntity(T entity) throws InstantiationException, IllegalAccessException,
//			ClassNotFoundException, NoSuchFieldException, SecurityException {
//		T entity = (T) eClass.newInstance();
//		for (String key : qData.keySet()) {
//			Field field = eClass.getDeclaredField(key);
//			field.setAccessible(true);
//			field.set(entity, qData.get(key));
//		}
//		return entity;
//	}

}
