package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.CategoryRepository;
import com.zeraki.languagelearning.Repositories.UserRepository;
import com.zeraki.languagelearning.dto.CategoryDto;
import com.zeraki.languagelearning.dto.CreateCategoryDto;
import com.zeraki.languagelearning.dto.UserCreateDto;
import com.zeraki.languagelearning.dto.UserDto;
import com.zeraki.languagelearning.entities.Category;
import com.zeraki.languagelearning.entities.User;
import com.zeraki.languagelearning.mappers.CategoryMapper;
import com.zeraki.languagelearning.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    public List<CategoryDto> getAllCategories(){
        // return this.store;      // this is for in memory data
        return this.categoryMapper.createDtoFromEntity(categoryRepository.findAll());
    }

    public CategoryDto createCategory(CreateCategoryDto user){
        Category productCategory = categoryMapper.userCreateDTOToEntity(user);

        productCategory = categoryRepository.save(productCategory);
        return categoryMapper.toDto(productCategory);
    }

}
