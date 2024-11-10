package com.it.itlens.models.dtos.SurveyEdition;

import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.validation.annotations.Exists;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSurveyEditionDTO {
    @PastOrPresent(message = "La date de création doit être dans le passé ou aujourd'hui.")
    private LocalDate creationDate;
    @Future(message = "La date de début doit être dans le futur.")
    private LocalDate startDate;

    private Integer year;

    @Exists(entity = Survey.class, message = "Cet survey n'existe pas.")
    private Long surveyId;
}
