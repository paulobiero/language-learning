package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.ProgressExerciseRepository;
import com.zeraki.languagelearning.Repositories.UserProgressRepository;
import com.zeraki.languagelearning.dto.*;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.ProgressExercise;
import com.zeraki.languagelearning.entities.User;
import com.zeraki.languagelearning.entities.UserProgress;
import com.zeraki.languagelearning.mappers.UserProgressMapper;
import com.zeraki.languagelearning.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class UserProgressService {

  @Autowired
    private UserProgressRepository userProgressRepository;

  @Autowired
    private UserProgressMapper userProgressMapper;

    @Autowired
    private exerciseService exerciseService;

    @Autowired
    private progressExerciseService progressExerciseService;



    public UserProgressDto startLesson(CreateUserProgress user, User userModel){
        UserProgress productCategory = userProgressMapper.createUserProgresstoEntity(user);
        productCategory.setDateStarted(new Timestamp(new Date().getTime()));
        productCategory.setStatus("PENDING");
        productCategory.setUser(userModel.getId());

        productCategory = userProgressRepository.save(productCategory);
        List<ExerciseDto> exerciseDtoList=exerciseService.getAllByLesson(productCategory.getLesson());
        for (ExerciseDto exerciseDto : exerciseDtoList) {
            progressExerciseService.createProgressExercise(productCategory.getId(),exerciseDto.getId());
        }
        return userProgressMapper.toDto(productCategory);
    }


    public List<UserProgressDto> getUserProgress(int id){
        List<UserProgress> progress=userProgressRepository.findAllByUser(id);

        return userProgressMapper.createDtoFromEntity(progress);
    }
}
