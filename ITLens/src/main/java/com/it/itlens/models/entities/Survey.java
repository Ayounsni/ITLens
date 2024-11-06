package com.it.itlens.models.entities;

import com.it.itlens.validation.annotations.Unique;
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
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Unique(entity = Survey.class, field = "title")
    private String title;

    @NotBlank
    private String description;

    @ManyToOne
    private Owner owner;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<SurveyEdition> surveyEditions ;
}

