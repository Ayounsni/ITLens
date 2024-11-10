package com.it.itlens.models.dtos.Survey;

import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.validation.annotations.Exists;
import com.it.itlens.validation.annotations.Unique;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSurveyDTO {
    @Unique(entity = Survey.class, field = "title")
    private String title;
    private String description;
    @Exists(entity = Owner.class, message = "Cet owner n'existe pas.")
    private Long ownerId ;
}
