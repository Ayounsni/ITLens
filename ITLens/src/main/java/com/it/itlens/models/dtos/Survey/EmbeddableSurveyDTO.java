package com.it.itlens.models.dtos.Survey;

import com.it.itlens.models.dtos.Owner.EmbeddableOwnerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddableSurveyDTO {
    private Long id;
    private String title;
    private String description;
}
