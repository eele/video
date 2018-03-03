package edu.zhku.jsj144.lzc.video.service;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.zhku.jsj144.lzc.video.pojo.IDInfo;

@Produces(MediaType.APPLICATION_JSON)
public interface BaseService<enT, mapperT> {

	// Return UUID
	@POST
	public IDInfo create(@BeanParam enT entity) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	@PUT
	@Path("/{id}")
	public void update(@BeanParam enT entity);

	@DELETE
	@Path("/{id}")
	public void deleteByID(@BeanParam enT entity);

}