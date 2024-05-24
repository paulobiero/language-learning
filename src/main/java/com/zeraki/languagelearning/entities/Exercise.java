package com.zeraki.languagelearning.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Exercise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "lesson", nullable = true)
    private Integer lesson;
    @Basic
    @Column(name = "date_created", nullable = true)
    private Timestamp dateCreated;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id && Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(lesson, exercise.lesson) && Objects.equals(dateCreated, exercise.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, lesson, dateCreated);
    }


}
