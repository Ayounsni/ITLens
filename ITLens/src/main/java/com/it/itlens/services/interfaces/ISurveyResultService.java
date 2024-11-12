package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Results.SurveyResultDTO;

public interface ISurveyResultService {
    SurveyResultDTO getSurveyResults(Long surveyId);
}
