package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.CategoryDto;
import com.zeraki.languagelearning.dto.CreateCategoryDto;
import com.zeraki.languagelearning.dto.CreateLessonDto;
import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.entities.Category;
import com.zeraki.languagelearning.entities.Lesson;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {
    Lesson toEntity(LessonDto lessonDto);

    List<LessonDto> createDtoFromEntity(List<Lesson> paymentMode);
    Lesson lessonCreateDTOToEntity(CreateLessonDto createLessonDto);



    LessonDto toDto(Lesson lesson);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Lesson partialUpdate(LessonDto lessonDto, @MappingTarget Lesson lesson);
}