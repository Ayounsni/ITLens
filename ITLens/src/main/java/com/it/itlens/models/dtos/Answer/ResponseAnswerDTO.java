package com.it.itlens.models.dtos.Answer;

import com.it.itlens.models.dtos.Question.EmbeddableQuestionDTO;
import com.it.itlens.models.entities.Question;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAnswerDTO {
    private Long id;

    private String text;

    private Integer selectionCount;

    private EmbeddableQuestionDTO question;
}
