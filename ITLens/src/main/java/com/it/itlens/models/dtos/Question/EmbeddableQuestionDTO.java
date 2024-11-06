package com.it.itlens.models.dtos.Question;

import com.it.itlens.models.dtos.Answer.EmbeddableAnswerDTO;
import com.it.itlens.models.dtos.Subject.EmbeddableSubjectDTO;
import com.it.itlens.models.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddableQuestionDTO {
    private Long id;

    private String text;

    private Integer answerCount;

    private QuestionType questionType;


}
