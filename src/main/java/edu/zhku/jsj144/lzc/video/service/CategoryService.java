package edu.zhku.jsj144.lzc.video.service;

import edu.zhku.jsj144.lzc.video.pojo.Category;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("categories")
public interface CategoryService {

    @GET
    public List<Category> getCategories();
}
