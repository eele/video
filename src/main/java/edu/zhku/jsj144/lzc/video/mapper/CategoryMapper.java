package edu.zhku.jsj144.lzc.video.mapper;

import edu.zhku.jsj144.lzc.video.pojo.Category;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    public List<Category> selectCategories();
}
