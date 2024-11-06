package com.it.itlens.models.dtos.Question;

import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.enums.QuestionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateQuestionDTO {

    @NotBlank
    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @NotNull
    private Long subjectId;


}
