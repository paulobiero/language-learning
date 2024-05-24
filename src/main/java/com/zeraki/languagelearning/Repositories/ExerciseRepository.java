package com.zeraki.languagelearning.Repositories;

import com.zeraki.languagelearning.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    List<Exercise> findAllByLesson(Integer lesson);
}