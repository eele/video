package edu.zhku.jsj144.lzc.video.service;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;

import edu.zhku.jsj144.lzc.video.service.impl.VideoServiceImpl;

public class Cp {
	public static void main(String[] args) throws CannotCompileException, NotFoundException {
//		ClassPool classPool = ClassPool.getDefault();
//		CtClass ctClass = classPool.get("org.apache.cxf.jaxrs.model.ClassResourceInfo");
//		CtMethod ctMethod = ctClass.getDeclaredMethod("initBeanParamInfo");
//		ctMethod.insertAt(305, 
//				"	if (cls.getSuperclass() == null) {\r\n" + 
//				"		Class superclass = ori.getClassResourceInfo().getServiceClass().getSuperclass();\r\n" + 
//				"		java.lang.reflect.Type t = superclass.getGenericSuperclass();\r\n" + 
//				"		if (t instanceof java.lang.reflect.ParameterizedType) {\r\n" + 
//				"			java.lang.reflect.Type[] p = ((java.lang.reflect.ParameterizedType) t).getActualTypeArguments();\r\n" + 
//				"			cls = (Class) p[0];\r\n" + 
//				"		}\r\n" + 
//				"	}\r\n"
//				);
		
		System.out.println((Class) ((java.lang.reflect.ParameterizedType) VideoServiceImpl.class.getGenericSuperclass()).getActualTypeArguments()[0]);
	}
}
