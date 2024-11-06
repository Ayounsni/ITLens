package com.it.itlens.models.dtos.Question;

import com.it.itlens.models.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateQuestionDTO {

    private String text;

    private QuestionType questionType;

    private Long subjectId;
}
