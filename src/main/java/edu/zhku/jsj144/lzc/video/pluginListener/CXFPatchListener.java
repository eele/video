package edu.zhku.jsj144.lzc.video.pluginListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;

/**
 * CXF补丁
 * 
 * @author ele
 *
 */
public class CXFPatchListener implements ServletContextListener {

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * 打补丁，解决@BeanParam无法绑定泛型Bean的问题
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			ClassPool classPool = ClassPool.getDefault();
			CtClass ctClass = classPool.get("org.apache.cxf.jaxrs.model.ClassResourceInfo");
			CtMethod ctMethod = ctClass.getDeclaredMethod("initBeanParamInfo");
			ctMethod.insertAt(305, 
			"	if (cls.getSuperclass() == null) {\r\n" + 
			"		Class clazz = ori.getClassResourceInfo().getServiceClass();\r\n" + 
			"		java.lang.reflect.Type t = clazz.getGenericSuperclass();\r\n" + 
			"		java.lang.reflect.Type[] p = ((java.lang.reflect.ParameterizedType) t).getActualTypeArguments();\r\n" + 
			"		cls = (Class) p[0];\r\n" + 
			"	}\r\n"
					);
			ctClass.toClass();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
