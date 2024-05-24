package com.zeraki.languagelearning.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "progress_exercise", schema = "zeraki_language_learning", catalog = "")
public class ProgressExercise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "status", nullable = true)
    private Object status;
    @Basic
    @Column(name = "started_date", nullable = true)
    private Timestamp startedDate;
    @Basic
    @Column(name = "end_time", nullable = true)
    private Timestamp endTime;
    @Basic
    @Column(name = "user_progress", nullable = true)
    private Integer userProgress;
    @Basic
    @Column(name = "exercise", nullable = true,insertable=false, updatable=false)
    private Integer exercise;
    @ManyToOne
    @JoinColumn(name = "user_progress", referencedColumnName = "id",insertable=false, updatable=false)
    private UserProgress userProgressByUserProgress;
    @ManyToOne
    @JoinColumn(name = "exercise", referencedColumnName = "id")
    private Exercise exerciseByExercise;
    @Basic
    @Column(name = "score", nullable = true)
    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Timestamp getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Timestamp startedDate) {
        this.startedDate = startedDate;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Integer getUserProgress() {
        return userProgress;
    }

    public void setUserProgress(Integer userProgress) {
        this.userProgress = userProgress;
    }

    public Integer getExercise() {
        return exercise;
    }

    public void setExercise(Integer exercise) {
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgressExercise that = (ProgressExercise) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(startedDate, that.startedDate) && Objects.equals(endTime, that.endTime) && Objects.equals(userProgress, that.userProgress) && Objects.equals(exercise, that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, startedDate, endTime, userProgress, exercise);
    }

    public UserProgress getUserProgressByUserProgress() {
        return userProgressByUserProgress;
    }

    public void setUserProgressByUserProgress(UserProgress userProgressByUserProgress) {
        this.userProgressByUserProgress = userProgressByUserProgress;
    }

    public Exercise getExerciseByExercise() {
        return exerciseByExercise;
    }

    public void setExerciseByExercise(Exercise exerciseByExercise) {
        this.exerciseByExercise = exerciseByExercise;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
