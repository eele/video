package edu.zhku.jsj144.lzc.video.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;

import edu.zhku.jsj144.lzc.video.pojo.ExceptionInfo;

public class ExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		// TODO Auto-generated method stub
		e.printStackTrace();
		ExceptionInfo exceptionInfo = null;
		Method[] methods = getClass().getDeclaredMethods();
		int flag = 0;
		for (Method m: methods) {
			if (m.getName().equals("handleException")
					&& e.getClass().isAssignableFrom(m.getParameterTypes()[0])) {
				try {
					exceptionInfo = (ExceptionInfo) m.invoke(this, e);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				flag = 1;
				break;
			}
		}
		
		if (flag == 0) {
			exceptionInfo = new ExceptionInfo().status("SERVERERR").msg("服务端异常,请稍后重试");
		}

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionInfo)
				.type("application/json;charset=UTF-8").build();
	}
	
	public ExceptionInfo handleException(DataIntegrityViolationException e) {
		return new ExceptionInfo().status("DBERR").msg("数据存取异常");
	}
	
	public ExceptionInfo handleException(BadSqlGrammarException e) {
		return new ExceptionInfo().status("DBERR").msg("数据库异常");
	}

}
