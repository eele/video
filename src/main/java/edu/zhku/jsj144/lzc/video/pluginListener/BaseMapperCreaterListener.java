package edu.zhku.jsj144.lzc.video.pluginListener;

import java.io.File;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtField;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.apache.ibatis.javassist.bytecode.annotation.ArrayMemberValue;
import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;

/**
 * 为各个Mapper类添加create、update、delete方法（批量代码生成）
 * 
 * @author ele
 *
 */
public class BaseMapperCreaterListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ClassPool classPool = ClassPool.getDefault();
			String[] cNames = getClasses();

			for (String cName : cNames) {
				if (!cName.equals("BaseMapper")) {
					CtClass ctClass = classPool.get("edu.zhku.jsj144.lzc.video.mapper." + cName);
					addMethod(classPool, ctClass, "create", "org.apache.ibatis.annotations.Insert", 
							createInsertSql(classPool, ctClass));
					addMethod(classPool, ctClass, "update", "org.apache.ibatis.annotations.Update", 
							createUpdateSql(classPool, ctClass));
					addMethod(classPool, ctClass, "delete", "org.apache.ibatis.annotations.Delete", 
							createDeleteSql(classPool, ctClass));
					ctClass.toClass();
				}
			}
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取mapper包下所有类名
	 * 
	 * @return
	 */
	private String[] getClasses() {
		String classpath = Thread.currentThread().getContextClassLoader().getResource("\\").getPath();
		File classDir = new File(classpath + "edu/zhku/jsj144/lzc/video/mapper");
		File[] classes = classDir.listFiles();
		String[] cNames = new String[classes.length];
		for (int i = 0; i < classes.length; i++) {
			cNames[i] = classes[i].getName().substring(0, classes[i].getName().length() - 6);
		}
		return cNames;
	}
	
	/**
	 * 在Mapper类中添加方法
	 * @param classPool
	 * @param ctClass
	 * @param mName
	 * @param aType
	 * @param aValue
	 * @throws NotFoundException
	 * @throws CannotCompileException
	 */
	private void addMethod(ClassPool classPool, CtClass ctClass, String mName, String aType, String aValue) throws NotFoundException, CannotCompileException {
		String genericType = ctClass.getGenericSignature();
		genericType = genericType.substring(genericType.lastIndexOf("/") + 1, genericType.length() - 3);
		CtMethod ctMethod = new CtMethod(
				CtClass.voidType, 
				mName,
				new CtClass[] { classPool.get("edu.zhku.jsj144.lzc.video.pojo." + genericType) }, 
				ctClass);
		ConstPool cp = ctClass.getClassFile().getConstPool();
		AnnotationsAttribute attr = new AnnotationsAttribute(cp, AnnotationsAttribute.visibleTag);
		Annotation annotation = new Annotation(aType, cp);
		ArrayMemberValue arrayMemberValue = new ArrayMemberValue(cp);
		arrayMemberValue.setValue(
				new StringMemberValue[] { new StringMemberValue(aValue, cp) });
		annotation.addMemberValue("value", arrayMemberValue);
		attr.addAnnotation(annotation);
		ctMethod.getMethodInfo().addAttribute(attr);
		ctClass.addMethod(ctMethod);
	}
	
	private String createInsertSql(ClassPool classPool, CtClass ctClass) throws NotFoundException {
		String genericType = ctClass.getGenericSignature();
		genericType = genericType.substring(genericType.lastIndexOf("/") + 1, genericType.length() - 3);
		CtClass entityClass = classPool.get("edu.zhku.jsj144.lzc.video.pojo." + genericType);
		StringBuilder sqlb = new StringBuilder("insert into " + genericType + "(");
		for (CtField f: entityClass.getDeclaredFields()) {
			sqlb.append(f.getName() + ",");
		}
		sqlb.deleteCharAt(sqlb.length() - 1);
		sqlb.append(") values(");
		for (CtField f: entityClass.getDeclaredFields()) {
			sqlb.append("#{" + f.getName() + "},");
		}
		sqlb.deleteCharAt(sqlb.length() - 1);
		sqlb.append(")");
		return sqlb.toString();
	}
	
	private String createUpdateSql(ClassPool classPool, CtClass ctClass) throws NotFoundException {
		String genericType = ctClass.getGenericSignature();
		genericType = genericType.substring(genericType.lastIndexOf("/") + 1, genericType.length() - 3);
		CtClass entityClass = classPool.get("edu.zhku.jsj144.lzc.video.pojo." + genericType);
		StringBuilder sqlb = new StringBuilder("update " + genericType + " set ");
		for (CtField f: entityClass.getDeclaredFields()) {
			sqlb.append(f.getName() + "=").append("#{" + f.getName() + "},");
		}
		sqlb.deleteCharAt(sqlb.length() - 1);
		sqlb.append(" where id=#{id}");
		return sqlb.toString();
	}
	
	private String createDeleteSql(ClassPool classPool, CtClass ctClass) throws NotFoundException {
		String genericType = ctClass.getGenericSignature();
		genericType = genericType.substring(genericType.lastIndexOf("/") + 1, genericType.length() - 3);
		StringBuilder sqlb = new StringBuilder("delete from " + genericType + " where id=#{id}") ;
		return sqlb.toString();
	}
	
}
