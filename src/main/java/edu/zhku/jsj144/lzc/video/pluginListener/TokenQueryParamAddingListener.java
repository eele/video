package edu.zhku.jsj144.lzc.video.pluginListener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;

import edu.zhku.jsj144.lzc.video.plugin.RequireToken;

/**
 * 给Web服务的方法批量添加Token参数以接收URL参数中的Token
 * 
 * @author ele
 *
 */
public class TokenQueryParamAddingListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ClassPool classPool = ClassPool.getDefault();
		String[] cNames = getServiceClasses();

		for (String cName : cNames) {
			addTokenQueryParam(classPool, cName);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取service包下所有业务接口类名
	 * 
	 * @return
	 */
	private String[] getServiceClasses() {
		String classpath = Thread.currentThread().getContextClassLoader().getResource("\\").getPath();
		File classDir = new File(classpath + "edu/zhku/jsj144/lzc/video/service");
		File[] classes = classDir.listFiles();
		String[] cNames = new String[classes.length];
		for (int i = 0; i < classes.length; i++) {
			cNames[i] = classes[i].getName().substring(0, classes[i].getName().length() - 6);
		}
		return cNames;
	}

	private void addTokenQueryParam(ClassPool classPool, String cName) {
		try {
			CtClass ctClass = classPool.get("edu.zhku.jsj144.lzc.video.service." + cName);
			CtMethod[] ctMethods = ctClass.getDeclaredMethods();
			if (ctClass.hasAnnotation(RequireToken.class)) {
				
			}

			ctClass.toClass();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
