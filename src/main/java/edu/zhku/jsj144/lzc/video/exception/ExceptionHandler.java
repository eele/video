package edu.zhku.jsj144.lzc.video.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import edu.zhku.jsj144.lzc.video.pojo.ExceptionInfo;

public class ExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception e) {
		// TODO Auto-generated method stub
		e.printStackTrace();
		ExceptionInfo exceptionInfo = new ExceptionInfo().status(e.getClass().getSimpleName()).msg(e.getMessage());

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionInfo)
				.type("application/json;charset=UTF-8").build();
	}

}
