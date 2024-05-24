package com.zeraki.languagelearning.services;

import com.zeraki.languagelearning.Repositories.CategoryRepository;
import com.zeraki.languagelearning.Repositories.LessonRepository;
import com.zeraki.languagelearning.Repositories.UserProgressRepository;
import com.zeraki.languagelearning.controllers.LessonController;
import com.zeraki.languagelearning.dto.CategoryDto;
import com.zeraki.languagelearning.dto.CreateCategoryDto;
import com.zeraki.languagelearning.dto.CreateLessonDto;
import com.zeraki.languagelearning.dto.LessonDto;
import com.zeraki.languagelearning.entities.Category;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.User;
import com.zeraki.languagelearning.entities.UserProgress;
import com.zeraki.languagelearning.mappers.CategoryMapper;
import com.zeraki.languagelearning.mappers.LessonMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private LessonRepository lessonRepository;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(LessonController.class);


    @Autowired
    private UserProgressRepository userProgressRepository;
    public LessonDto createlesson(CreateLessonDto user){
        Lesson productCategory = lessonMapper.lessonCreateDTOToEntity(user);

        productCategory = lessonRepository.save(productCategory);
        return lessonMapper.toDto(productCategory);
    }

    public List<LessonDto> getAllLessons(){
        // return this.store;      // this is for in memory data
         return this.lessonMapper.createDtoFromEntity(lessonRepository.findAll());
    }
    public List<LessonDto> recommend(User user){
        // return this.store;      // this is for in memory data
        List<UserProgress>userProgressList=userProgressRepository.findAllByUserAndStatusOrderByIdDesc(user.getId(),"COMPLETED");
        logger.info("The completed are "+userProgressList.size());
        if (userProgressList.isEmpty())
        {
            this.lessonMapper.createDtoFromEntity(lessonRepository.findAll());
        }
        Lesson firstLesson=lessonRepository.findById(userProgressList.getFirst().getLesson()).orElse(null);
        List<Lesson>recommended=lessonRepository.findAllByCategory(firstLesson.getCategory());
        recommended.removeIf(lesson -> convertToLessonIds(userProgressList).contains(lesson.getId()));
        return this.lessonMapper.createDtoFromEntity(recommended);
    }
    private  List<Integer> convertToLessonIds(List<UserProgress> userProgresses) {
        ArrayList<Integer> ageList = new ArrayList<>();
        for (UserProgress person : userProgresses) {
            ageList.add(person.getLesson());
        }
        return ageList;
    }
    public LessonDto getLessonById(Integer id){
        // return this.store;      // this is for in memory data
        return this.lessonMapper.toDto(lessonRepository.findById(id).orElse(null));
    }
}
