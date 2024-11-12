package com.it.itlens.models.dtos.Results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubChapterResultDTO {
    private String title;
    private String question;
    private Map<String, Integer> answers;
    private int totalAnswers;
}

