package com.it.itlens.models.dtos.Subject;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubjectDTO {
    @NotBlank
    private String title;

    private Long parentSubjectId;

    @NotNull
    private Long surveyEditionId;

}
