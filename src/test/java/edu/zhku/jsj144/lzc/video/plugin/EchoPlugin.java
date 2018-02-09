//package edu.zhku.jsj144.lzc.video.plugin;
//
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import edu.zhku.jsj144.lzc.video.pojo.Echo;
//
//@Aspect
//@Component
//public class EchoPlugin {
//	
//	@Pointcut("execution(* edu.zhku.jsj144.lzc.video.service.BaseService.*(..))")
//	public void webAspect() {
//	}
//	
//	@AfterReturning(pointcut="webAspect()", returning="entity")
//	public Echo doEcho(Object entity) {
//		Echo echo = new Echo("OK");
//		System.out.println(entity);
//		echo.setData(entity);
//		return echo;
//	}
//}
