package com.it.itlens.services.implementation;

import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.dtos.SurveyEdition.CreateSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.UpdateSurveyEditionDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.models.mappers.SurveyEditionMapper;
import com.it.itlens.models.mappers.SurveyMapper;
import com.it.itlens.repository.SurveyEditionRepository;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.ISurveyEditionService;
import com.it.itlens.services.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

@Service
public class SurveyEditionService extends GenericService<SurveyEdition, CreateSurveyEditionDTO, UpdateSurveyEditionDTO, ResponseSurveyEditionDTO> implements ISurveyEditionService {

    public SurveyEditionService(SurveyEditionRepository surveyEditionRepository, SurveyEditionMapper surveyEditionMapper) {
        super(surveyEditionRepository,surveyEditionMapper);
    }

}
