package com.org.unixam_backend.model.exam;

import jakarta.persistence.*;

import com.org.unixam_backend.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int questionAttempted;

    private int correctAnswer;

    private int marksScored;

    private String sumbitDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;


}
