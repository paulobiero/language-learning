package com.zeraki.languagelearning.Repositories;

import com.zeraki.languagelearning.entities.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProgressRepository extends JpaRepository<UserProgress, Integer> {
    List<UserProgress>findAllByUser(int user);
    List<UserProgress>findAllByUserAndStatusOrderByIdDesc(int user,String status);
}