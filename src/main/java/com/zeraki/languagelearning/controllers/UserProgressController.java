package com.zeraki.languagelearning.controllers;

import com.zeraki.languagelearning.dto.*;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.User;
import com.zeraki.languagelearning.security.JwtHelper;
import com.zeraki.languagelearning.services.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User progress")
@RestController
@RequestMapping(value = "/user-progress",name = "user")
public class UserProgressController {


    @Autowired
    private CategoryService categoryService;


    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserProgressService userProgressService;

    @Autowired
    private progressExerciseService progressExerciseService;

    @Autowired
    private JwtHelper jwtHelper;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserProgressController.class);




    // mapping for creating user
    @PostMapping("/lesson/start")
    public ResponseEntity<UserProgressDto>  startLesson(@RequestBody CreateUserProgress categoryDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        logger.info("The user is "+user.getId());
        return ResponseEntity.ok(userProgressService.startLesson(categoryDto,user));

    }

    @PostMapping("/lesson/exercise")
    public ResponseEntity<List<ProgressExerciseDto>>  getLessonExercises(@RequestBody CompleteLessonDto categoryDto){
        return  ResponseEntity.ok(progressExerciseService.findAllByUserProgress(categoryDto.getId()));

    }
    @GetMapping("/lesson")
    public ResponseEntity<List<UserProgressDto>>  getLessonUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        logger.info("The user is "+user.getEmail());
        return  ResponseEntity.ok(userProgressService.getUserProgress(user.getId()));

    }
    @GetMapping("/lesson/recommend")
    public ResponseEntity<List<LessonDto>> recommendLessons(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        logger.info("The user is "+user.getEmail());
        return  ResponseEntity.ok(lessonService.recommend(user));

    }
    @PostMapping("/lesson/exercise/start")
    public ResponseEntity<ProgressExerciseDto>  startExercise(@RequestBody CompleteLessonDto categoryDto){
        return  ResponseEntity.ok(progressExerciseService.startProgressExercise(categoryDto.getId()));

    }
    @PostMapping("/lesson/exercise/complete")
    public ResponseEntity<ProgressExerciseDto>  completeExercise(@RequestBody CompleteExerciseDto categoryDto){
        return  ResponseEntity.ok(progressExerciseService.completeProgressExercise(categoryDto.getId(),categoryDto.getScore()));

    }


}
