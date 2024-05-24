package com.zeraki.languagelearning.mappers;

import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.dto.ProgressExerciseDto;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.ProgressExercise;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProgressExerciseMapper {
    ProgressExercise toEntity(ProgressExerciseDto progressExerciseDto);

    ProgressExerciseDto toDto(ProgressExercise progressExercise);
    List<ProgressExerciseDto> createDtoFromEntity(List<ProgressExercise> paymentMode);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ProgressExercise partialUpdate(ProgressExerciseDto progressExerciseDto, @MappingTarget ProgressExercise progressExercise);
}