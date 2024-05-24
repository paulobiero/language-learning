package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.CreateExerciseDto;
import com.zeraki.languagelearning.dto.ExerciseDto;
import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.entities.Exercise;
import com.zeraki.languagelearning.entities.Lesson;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExerciseMapper {
    Exercise toEntity(ExerciseDto exerciseDto);

    Exercise createDtoToEntity(CreateExerciseDto createExerciseDto);
    List<ExerciseDto> createDtoFromEntity(List<Exercise> paymentMode);

    ExerciseDto toDto(Exercise exercise);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Exercise partialUpdate(ExerciseDto exerciseDto, @MappingTarget Exercise exercise);
}