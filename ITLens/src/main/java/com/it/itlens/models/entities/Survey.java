package com.it.itlens.models.entities;

import com.it.itlens.validation.annotations.Unique;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Unique(entity = Survey.class, field = "title")
    private String title;

    private String description;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<SurveyEdition> surveyEditions ;
}

