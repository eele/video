package edu.zhku.jsj144.lzc.video.plugin;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 令牌认证切面
 * 
 * @author ele
 *
 */
@Aspect
@Component
public class AuthAspect {

	@Pointcut("@annotation(edu.zhku.jsj144.lzc.video.plugin.RequireToken)")
	public void point() {
	}
	
	@Before("point()")
	public void checkToken(JoinPoint joinPoint) {
		
	}
}
