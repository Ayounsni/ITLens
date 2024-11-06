package com.it.itlens.models.dtos.Answer;

import com.it.itlens.models.entities.Question;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnswerDTO {
    @NotBlank
    private String text;

    @NotNull
    private Long questionId;
}
