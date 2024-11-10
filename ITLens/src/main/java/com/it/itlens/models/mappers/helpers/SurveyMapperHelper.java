package com.it.itlens.models.mappers.helpers;

import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.repository.OwnerRepository;
import com.it.itlens.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SurveyMapperHelper {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey mapSurveyIdToSurvey(Long surveyId) {
        return surveyRepository.findById(surveyId).orElse(null);
    }
}
