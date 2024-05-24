package com.zeraki.languagelearning.Repositories;

import com.zeraki.languagelearning.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson>findAllByCategory(int category);
}