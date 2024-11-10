package com.it.itlens.services.implementation;

import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.mappers.SurveyMapper;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

@Service
public class SurveyService extends GenericService<Survey, CreateSurveyDTO, UpdateSurveyDTO, ResponseSurveyDTO> implements ISurveyService {

    public SurveyService(SurveyRepository surveyRepository ,SurveyMapper surveyMapper) {
        super(surveyRepository , surveyMapper);
    }

}
