package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.CreateUserProgress;
import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.dto.UserProgressDto;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.UserProgress;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserProgressMapper {
    UserProgress toEntity(UserProgressDto userProgressDto);

    UserProgress createUserProgresstoEntity(CreateUserProgress userProgressDto);
    UserProgressDto toDto(UserProgress userProgress);
    List<UserProgressDto> createDtoFromEntity(List<UserProgress> paymentMode);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProgress partialUpdate(UserProgressDto userProgressDto, @MappingTarget UserProgress userProgress);
}