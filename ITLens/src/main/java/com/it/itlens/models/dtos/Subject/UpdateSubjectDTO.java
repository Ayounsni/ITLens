package com.it.itlens.models.dtos.Subject;

import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.validation.annotations.Exists;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSubjectDTO {

    private String title;

    @Exists(entity = Subject.class, message = "Cet subject n'existe pas.")
    private Long parentSubjectId;

    @Exists(entity = SurveyEdition.class, message = "Cet surveyEdition n'existe pas.")
    private Long surveyEditionId;
}
