package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.ProgressExerciseRepository;
import com.zeraki.languagelearning.Repositories.UserProgressRepository;
import com.zeraki.languagelearning.dto.CreateUserProgress;
import com.zeraki.languagelearning.dto.ProgressExerciseDto;
import com.zeraki.languagelearning.dto.UserProgressDto;
import com.zeraki.languagelearning.entities.ProgressExercise;
import com.zeraki.languagelearning.entities.UserProgress;
import com.zeraki.languagelearning.mappers.ProgressExerciseMapper;
import com.zeraki.languagelearning.mappers.UserProgressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class progressExerciseService {
    @Autowired
    private ProgressExerciseRepository progressExerciseRepository;

    @Autowired
    private ProgressExerciseMapper progressExerciseMapper;

    @Autowired
    private UserProgressRepository userProgressRepository;
    public ProgressExerciseDto createProgressExercise(int  user_progress,int exercise){
        ProgressExerciseDto progressExerciseDto=new ProgressExerciseDto();
        progressExerciseDto.setExercise(exercise);
        progressExerciseDto.setStatus("PENDING");
        progressExerciseDto.setUserProgress(user_progress);
         ProgressExercise productCategory = progressExerciseMapper.toEntity(progressExerciseDto);

        productCategory = progressExerciseRepository.save(productCategory);
        return progressExerciseMapper.toDto(productCategory);
    }

    public ProgressExerciseDto startProgressExercise(int id){
        ProgressExercise progress=progressExerciseRepository.findById(id).orElse(null);
        if (progress!=null)
        {
            progress.setStatus("STARTED");
            progress.setStartedDate(new Timestamp(new Date().getTime()));
            progress=progressExerciseRepository.save(progress);
        }
        return progressExerciseMapper.toDto(progress);
    }

    public ProgressExerciseDto completeProgressExercise(int id,int score){
        ProgressExercise progress=progressExerciseRepository.findById(id).orElse(null);
        if (progress!=null)
        {
            progress.setStatus("COMPLETED");
            progress.setScore(score);
            progress.setEndTime(new Timestamp(new Date().getTime()));
            progress=progressExerciseRepository.save(progress);
        }
        List<ProgressExercise>getAllProgressExercises=progressExerciseRepository.findAllByUserProgress(progress.getUserProgress());
        boolean allCompleted = true;
        int totalScore = 0;
        for (ProgressExercise getAllProgressExercise : getAllProgressExercises) {
            if (!getAllProgressExercise.getStatus().equals("COMPLETED")) {
                allCompleted = false;

            }
            totalScore+=getAllProgressExercise.getScore();
        }
        if (allCompleted){
            UserProgress userProgress=userProgressRepository.findById(progress.getUserProgress()).orElse(null);
            if (userProgress!=null)
            {
                userProgress.setStatus("COMPLETED");
                userProgress.setScore(totalScore);
                userProgress.setDateCompleted(new Timestamp(new Date().getTime()));
                userProgress=userProgressRepository.save(userProgress);
            }
        }
        return progressExerciseMapper.toDto(progress);
    }
    public List<ProgressExerciseDto> findAllByUserProgress(int id){
        List<ProgressExercise> progress=progressExerciseRepository.findAllByUserProgress(id);

        return progressExerciseMapper.createDtoFromEntity(progress);
    }

}
