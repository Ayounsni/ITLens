package com.it.itlens.models.entities;


import com.it.itlens.models.enums.QuestionType;
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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String text;

    private Integer answerCount = 0;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Answer> answers;

    public void incrementAnswerCount() {
        this.answerCount++;
    }

}


