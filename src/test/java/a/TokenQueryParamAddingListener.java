package a;

import edu.zhku.jsj144.lzc.video.plugin.annotation.RequireToken;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.ClassFile;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.ParameterAnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.apache.ibatis.javassist.bytecode.annotation.ArrayMemberValue;
import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

/**
 * 给Web服务的方法批量添加Token参数以接收URL参数中的Token
 *
 * @author ele
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
     * 获取service.impl包下所有业务类名
     *
     * @return
     */
    private String[] getServiceClasses() {
        String classpath = Thread.currentThread().getContextClassLoader().getResource("\\").getPath();
        File classDir = new File(classpath + "edu/zhku/jsj144/lzc/video/service/impl");
        File[] classes = classDir.listFiles();
        String[] cNames = new String[classes.length];
        for (int i = 0; i < classes.length; i++) {
            cNames[i] = classes[i].getName().substring(0, classes[i].getName().length() - 6);
        }
        return cNames;
    }

    /**
     * 添加Token查询参数到业务方法中
     *
     * @param classPool
     * @param cName
     */
    private void addTokenQueryParam(ClassPool classPool, String cName) {
        try {
            CtClass ctClass = classPool.get("edu.zhku.jsj144.lzc.video.service.impl." + cName);  // 业务实现类
            CtClass ctInClass = ctClass.getInterfaces()[0]; // 业务接口
            CtMethod[] ctMethods = ctInClass.getDeclaredMethods();

            for (CtMethod ctMethod : ctMethods) {
                if (ctInClass.hasAnnotation(RequireToken.class) || ctMethod.hasAnnotation(RequireToken.class)) {
                    CtClass pType = classPool.get("java.lang.String");
                    ClassFile classFile = pType.getClassFile();
                    ConstPool cp = classFile.getConstPool();
                    ParameterAnnotationsAttribute pAttr =
                            new ParameterAnnotationsAttribute(cp, ParameterAnnotationsAttribute.visibleTag);
                    Annotation queryParamAnnotation = new Annotation("javax.ws.rs.QueryParam", cp);
                    ArrayMemberValue arrayMemberValue = new ArrayMemberValue(cp);
                    arrayMemberValue.setValue(
                            new StringMemberValue[]{ new StringMemberValue("token", cp) });
                    queryParamAnnotation.addMemberValue("value", arrayMemberValue);
                    Annotation[][] paramArrays = new Annotation[1][1];
                    paramArrays[0][0] = queryParamAnnotation;
                    pAttr.setAnnotations(paramArrays);
                    classFile.addAttribute(pAttr);
                    ctMethod.addParameter(pType);
                    ctClass.getDeclaredMethod(ctMethod.getName()).addParameter(classPool.get("java.lang.String"));
                }
            }

            ctInClass.toClass();
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
