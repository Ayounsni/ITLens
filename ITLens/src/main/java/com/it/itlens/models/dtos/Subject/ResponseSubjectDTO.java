package com.it.itlens.models.dtos.Subject;

import com.it.itlens.models.dtos.Question.EmbeddableQuestionDTO;
import com.it.itlens.models.dtos.SurveyEdition.EmbeddableSurveyEditionDTO;
import com.it.itlens.models.entities.Question;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.SurveyEdition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSubjectDTO {
    private Long id;

    private String title;

    private EmbeddableSubjectDTO parentSubject;

    private List<EmbeddableSubjectDTO> subSubjects;

    private EmbeddableSurveyEditionDTO surveyEdition;

    private List<EmbeddableQuestionDTO> questions;
}
