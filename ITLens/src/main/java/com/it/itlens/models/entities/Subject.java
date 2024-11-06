package com.it.itlens.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @ManyToOne
    private Subject parentSubject;

    @OneToMany(mappedBy = "parentSubject", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Subject> subSubjects;

    @ManyToOne
    private SurveyEdition surveyEdition;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Question> questions;


}
