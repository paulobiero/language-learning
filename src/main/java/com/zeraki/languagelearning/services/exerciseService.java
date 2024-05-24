package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.CategoryRepository;
import com.zeraki.languagelearning.Repositories.ExerciseRepository;
import com.zeraki.languagelearning.dto.CreateExerciseDto;
import com.zeraki.languagelearning.dto.CreateLessonDto;
import com.zeraki.languagelearning.dto.ExerciseDto;
import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.entities.Exercise;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.mappers.CategoryMapper;
import com.zeraki.languagelearning.mappers.ExerciseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class exerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseMapper exerciseMapper;
    public ExerciseDto createExercise(CreateExerciseDto user){
        Exercise productCategory = exerciseMapper.createDtoToEntity(user);

        productCategory = exerciseRepository.save(productCategory);
        return exerciseMapper.toDto(productCategory);
    }
    public List<ExerciseDto> getAllByLesson(Integer lesson){

        return this.exerciseMapper.createDtoFromEntity(exerciseRepository.findAllByLesson(lesson));
    }
}
