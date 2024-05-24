package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.CategoryDto;
import com.zeraki.languagelearning.dto.CreateCategoryDto;
import com.zeraki.languagelearning.dto.UserCreateDto;
import com.zeraki.languagelearning.entities.Category;
import com.zeraki.languagelearning.entities.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    Category userCreateDTOToEntity(CreateCategoryDto createCategoryDto);

    List<CategoryDto> createDtoFromEntity(List<Category> paymentMode);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);
}