package com.zeraki.languagelearning.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user_progress", schema = "zeraki_language_learning", catalog = "")
public class UserProgress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user", nullable = true)
    private Integer user;
    @Basic
    @Column(name = "lesson", nullable = true)
    private Integer lesson;
    @Basic
    @Column(name = "status", nullable = true)
    private String status;
    @Basic
    @Column(name = "date_started", nullable = true)
    private Timestamp dateStarted;
    @Basic
    @Column(name = "date_completed", nullable = true)
    private Timestamp dateCompleted;
    @Basic
    @Column(name = "score", nullable = true)
    private Integer score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Timestamp dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Timestamp getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Timestamp dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProgress that = (UserProgress) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(lesson, that.lesson) && Objects.equals(status, that.status) && Objects.equals(dateStarted, that.dateStarted) && Objects.equals(dateCompleted, that.dateCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, lesson, status, dateStarted, dateCompleted);
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
