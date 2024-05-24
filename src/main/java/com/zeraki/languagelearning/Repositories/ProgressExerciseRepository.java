package com.zeraki.languagelearning.Repositories;

import com.zeraki.languagelearning.entities.ProgressExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressExerciseRepository extends JpaRepository<ProgressExercise, Integer> {

    List<ProgressExercise>findAllByUserProgress(int progress);
}