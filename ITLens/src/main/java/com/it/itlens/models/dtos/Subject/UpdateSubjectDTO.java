package com.it.itlens.models.dtos.Subject;

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

    private Long parentSubjectId;

    private Long surveyEditionId;
}
