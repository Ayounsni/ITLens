package com.it.itlens.models.dtos.SurveyEdition;

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

    private LocalDate creationDate;

    private LocalDate startDate;

    private Integer year;

    private Long surveyId;
}
