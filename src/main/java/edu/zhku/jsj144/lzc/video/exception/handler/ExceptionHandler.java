package edu.zhku.jsj144.lzc.video.exception.handler;

import edu.zhku.jsj144.lzc.video.exception.IllegalResourceAccessException;
import edu.zhku.jsj144.lzc.video.exception.RequireTokenException;
import edu.zhku.jsj144.lzc.video.pojo.ExceptionInfo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionHandler implements ExceptionMapper<Exception> {

    public ExceptionInfo handleException(DataIntegrityViolationException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.INTERNAL_SERVER_ERROR)
                .status("DBERR").msg("数据存取异常");
    }

    public ExceptionInfo handleException(BadSqlGrammarException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.INTERNAL_SERVER_ERROR)
                .status("DBERR").msg("数据库异常");
    }

    public ExceptionInfo handleException(RequireTokenException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.FORBIDDEN)
                .status("TOKENERR").msg("需要令牌");
    }

    public ExceptionInfo handleException(SignatureException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.FORBIDDEN)
                .status("TOKENERR").msg("令牌不合法");
    }

    public ExceptionInfo handleException(MalformedJwtException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.FORBIDDEN)
                .status("TOKENERR").msg("令牌不合法");
    }

    public ExceptionInfo handleException(ExpiredJwtException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.FORBIDDEN)
                .status("TOKENERR").msg("令牌已过期");
    }

    public ExceptionInfo handleException(IllegalResourceAccessException e) {
        return new ExceptionInfo()
                .httpStatus(Response.Status.FORBIDDEN)
                .status("ACCERR").msg("访问其他用户资源的权限已禁止");
    }

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
			exceptionInfo = new ExceptionInfo()
                    .httpStatus(Response.Status.INTERNAL_SERVER_ERROR)
                    .status("SERVERERR").msg("服务端异常");
		}

		return Response.status(exceptionInfo.getHttpStatus()).entity(exceptionInfo)
				.type("application/json;charset=UTF-8").build();
	}

}
