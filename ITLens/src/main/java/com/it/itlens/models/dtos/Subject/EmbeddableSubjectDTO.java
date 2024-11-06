package com.it.itlens.models.dtos.Subject;

import com.it.itlens.models.dtos.SurveyEdition.EmbeddableSurveyEditionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddableSubjectDTO {
    private Long id;

    private String title;

}
