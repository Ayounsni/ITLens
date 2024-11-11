package com.it.itlens.models.mappers.helpers;

import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.repository.SurveyEditionRepository;
import com.it.itlens.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyEditionMapperHelper {

    @Autowired
    private SurveyEditionRepository surveyEditionRepository;

    public SurveyEdition mapSurveyEditionIdToSurveyEdition(Long surveyEditionId) {

        return surveyEditionRepository.findById(surveyEditionId).orElse(null);
    }
}
