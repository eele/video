package edu.zhku.jsj144.lzc.video.service;

import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/b/_$base")
@Produces(MediaType.APPLICATION_JSON)
public interface BaseService<T> {

	@POST
	public void create(@BeanParam T entity) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, NoSuchFieldException, SecurityException;

	@GET
	@Path("/{id}")
	public T get(@PathParam("id") String id);

	@GET
	public List<T> get(T entity);

	@PUT
	@Path("/{id}")
	public void update(@PathParam("id") String id, T entity);

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") String id);

	@DELETE
	public void delete(T entity);
}
