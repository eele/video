package edu.zhku.jsj144.lzc.video.service.impl;

import edu.zhku.jsj144.lzc.video.mapper.CategoryMapper;
import edu.zhku.jsj144.lzc.video.pojo.Category;
import edu.zhku.jsj144.lzc.video.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category, CategoryMapper> implements CategoryService {

    @Override
    public List<Category> getCategories() {
        return super.mapper.selectCategories();
    }
}
