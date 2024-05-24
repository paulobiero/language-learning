package com.zeraki.languagelearning.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * DTO for {@link com.zeraki.languagelearning.entities.UserProgress}
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserProgressDto implements Serializable {
    private  int id;
    private  Integer user;
    private  Integer lesson;
    private  String status;
    private  Timestamp dateStarted;
    private  Timestamp dateCompleted;
    private Integer score;


}