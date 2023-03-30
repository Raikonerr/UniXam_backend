package com.org.unixam_backend.model;

public record QuestionDto(String content,
                          String image,
                          String option1,
                          String option2,
                          String option3,
                          String option4,
                          String answer ,
                          Long quiz_id) implements java.io.Serializable{

}
