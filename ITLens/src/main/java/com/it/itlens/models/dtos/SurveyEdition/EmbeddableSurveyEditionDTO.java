package com.it.itlens.models.dtos.SurveyEdition;

import com.it.itlens.models.dtos.Survey.EmbeddableSurveyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddableSurveyEditionDTO {
    private Long id;

    private LocalDate creationDate;

    private LocalDate startDate;

    private Integer year;

}
