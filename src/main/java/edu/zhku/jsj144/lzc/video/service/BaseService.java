package edu.zhku.jsj144.lzc.video.service;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.zhku.jsj144.lzc.video.plugin.RequireToken;
import edu.zhku.jsj144.lzc.video.pojo.IDInfo;

/**
 * 基本业务层接口
 * @author ele
 *
 * @param <enT> 实体类型
 * @param <mapperT> Mapper类型
 */
@RequireToken
@Produces(MediaType.APPLICATION_JSON)
public interface BaseService<enT, mapperT> {

	/**
	 * 创建实体信息
	 * @param entity 实体
	 * @return 实体的ID信息
	 * @throws Exception
	 */
	@POST
	public IDInfo create(@BeanParam enT entity) throws Exception;

	@PUT
	@Path("/{id}")
	public void update(@BeanParam enT entity);

	@DELETE
	@Path("/{id}")
	public void deleteByID(@BeanParam enT entity);

}