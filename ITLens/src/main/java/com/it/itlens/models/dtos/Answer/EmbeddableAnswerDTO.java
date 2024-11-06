package com.it.itlens.models.dtos.Answer;

import com.it.itlens.models.dtos.Question.EmbeddableQuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddableAnswerDTO {
    private Long id;

    private String text;

    private Integer selectionCount;

}
