package com.it.itlens.models.dtos.SurveyEdition;

import com.it.itlens.models.entities.Survey;
import jakarta.persistence.ManyToOne;
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
public class CreateSurveyEditionDTO {

    @NotNull
    @PastOrPresent(message = "La date de création doit être dans le passé ou aujourd'hui.")
    private LocalDate creationDate;

    @NotNull
    @Future(message = "La date de début doit être dans le futur.")
    private LocalDate startDate;

    @NotNull
    private Integer year;

    @NotNull
    private Long surveyId;
}
