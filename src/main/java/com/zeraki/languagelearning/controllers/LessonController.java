package com.zeraki.languagelearning.controllers;

import com.zeraki.languagelearning.dto.*;
import com.zeraki.languagelearning.model.JWTRequest;
import com.zeraki.languagelearning.model.JWTResponse;
import com.zeraki.languagelearning.security.JwtHelper;
import com.zeraki.languagelearning.services.CategoryService;
import com.zeraki.languagelearning.services.LessonService;
import com.zeraki.languagelearning.services.UserService;
import com.zeraki.languagelearning.services.exerciseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "lessons")
@RestController
@RequestMapping(value = "/lessons",name = "lessons")
public class LessonController {


    @Autowired
    private CategoryService categoryService;


    @Autowired
    private LessonService lessonService;

    @Autowired
    private exerciseService exerciseService;




    private org.slf4j.Logger logger = LoggerFactory.getLogger(LessonController.class);




    // mapping for creating user
    @PostMapping("/category/create")
    public ResponseEntity<CategoryDto>  createCategory(@RequestBody CreateCategoryDto categoryDto){
        return  ResponseEntity.ok(categoryService.createCategory(categoryDto));

    }

    @PostMapping("/create")
    public ResponseEntity<LessonDto>  createLesson(@RequestBody CreateLessonDto categoryDto){
        return  ResponseEntity.ok(lessonService.createlesson(categoryDto));

    }
    @PostMapping("/exercise/create")
    public ResponseEntity<ExerciseDto> createExercise(@RequestBody CreateExerciseDto categoryDto){
        return  ResponseEntity.ok(exerciseService.createExercise(categoryDto));
    }

    @PostMapping("/exercise/{id}")
    public ResponseEntity<List<ExerciseDto>> getExercisesByLesson(@PathVariable("id") Integer orderId){
        return  ResponseEntity.ok(exerciseService.getAllByLesson(orderId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LessonDto>> getLessons(){

        return ResponseEntity.ok(lessonService.getAllLessons());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> getLesson(@PathVariable("id") Integer orderId){

        return ResponseEntity.ok(lessonService.getLessonById(orderId));
    }
    @GetMapping("/category/all")
    public ResponseEntity<List<CategoryDto>> getCategory(){

        return ResponseEntity.ok(categoryService.getAllCategories());

    }

}
