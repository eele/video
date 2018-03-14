package edu.zhku.jsj144.lzc.video.plugin;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 标注某业务方法的执行需要令牌认证
 * 
 * @author ele
 *
 */
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface RequireToken {

}
