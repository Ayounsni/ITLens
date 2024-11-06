package com.it.itlens.models.dtos.Survey;

import com.it.itlens.models.dtos.Owner.EmbeddableOwnerDTO;
import com.it.itlens.models.dtos.SurveyEdition.EmbeddableSurveyEditionDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.validation.annotations.Unique;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSurveyDTO {
    private Long id;

    private String title;

    private String description;

    private EmbeddableOwnerDTO owner;

    private List<EmbeddableSurveyEditionDTO> surveyEditions ;
}
