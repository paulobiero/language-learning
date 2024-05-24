package com.zeraki.languagelearning.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Lesson {
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
    @Column(name = "date_create", nullable = true)
    private Timestamp dateCreate;

    @Basic
    @Column(name = "category", nullable = true)
    private Integer category;

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

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id && Objects.equals(name, lesson.name) && Objects.equals(description, lesson.description) && Objects.equals(dateCreate, lesson.dateCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreate);
    }



    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
