package com.zeraki.languagelearning.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zeraki.languagelearning.entities.Lesson;
import com.zeraki.languagelearning.entities.ProgressExercise;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * DTO for {@link com.zeraki.languagelearning.entities.Exercise}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExerciseDto implements Serializable {
    private  int id;
    private  String name;
    private  String description;
    private  int lesson;
    private  Timestamp dateCreated;


}