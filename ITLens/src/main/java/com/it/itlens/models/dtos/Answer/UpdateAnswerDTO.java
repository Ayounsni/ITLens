package com.it.itlens.models.dtos.Answer;

import com.it.itlens.models.entities.Question;
import com.it.itlens.validation.annotations.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAnswerDTO {
    private String text;

    @Exists(entity = Question.class, message = "Cette question n'existe pas.")
    private Long questionId;
}
