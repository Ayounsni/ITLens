package com.it.itlens.models.dtos.Participation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Long questionId;
    private Long singleAnswerId;
    private List<AnswerDTO> multipleAnswers;
}
