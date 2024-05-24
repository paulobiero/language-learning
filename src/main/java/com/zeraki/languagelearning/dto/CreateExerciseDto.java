package com.zeraki.languagelearning.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link com.zeraki.languagelearning.entities.Exercise}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateExerciseDto implements Serializable {

    private  String name;
    private  String description;
    private  int lesson;

}