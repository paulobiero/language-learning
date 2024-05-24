package com.zeraki.languagelearning.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.zeraki.languagelearning.entities.UserProgress;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * DTO for {@link com.zeraki.languagelearning.entities.ProgressExercise}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProgressExerciseDto implements Serializable {
    private  int id;
    private  Object status;
    private  Timestamp startedDate;
    private  Timestamp endTime;
    private  int userProgress;
    private  int exercise;



}