package com.it.itlens.models.dtos.SurveyEdition;

import com.it.itlens.models.dtos.Subject.EmbeddableSubjectDTO;
import com.it.itlens.models.dtos.Survey.EmbeddableSurveyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSurveyEditionDTO {
    private Long id;

    private LocalDate creationDate;

    private LocalDate startDate;

    private Integer year;

    private EmbeddableSurveyDTO survey;

    private List<EmbeddableSubjectDTO> subjects;
}
