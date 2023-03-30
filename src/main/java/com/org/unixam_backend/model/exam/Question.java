package com.org.unixam_backend.model.exam;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;

    @Nullable
    private String image;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;


}
