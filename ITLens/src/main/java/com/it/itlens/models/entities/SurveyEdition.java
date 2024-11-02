package com.it.itlens.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate creationDate;
    private LocalDate startDate;
    private Integer year;

    @ManyToOne
    private Survey survey;

    @OneToMany(mappedBy = "surveyEdition", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Subject> subjects;
}

