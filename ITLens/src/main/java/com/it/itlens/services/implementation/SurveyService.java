package com.it.itlens.services.implementation;

import com.it.itlens.models.mappers.SurveyMapper;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService extends GenericService<Survey, CreateSurveyDTO, UpdateSurveyDTO, ResponseSurveyDTO> implements ISurveyService {
    @Autowired
    private  SurveyMapper surveyMapper;

    public SurveyService(SurveyRepository surveyRepository) {
        super(surveyRepository);
    }

    @Override
    protected Survey toEntity(CreateSurveyDTO createSurveyDTO) {
        return surveyMapper.toEntity(createSurveyDTO);
    }

    @Override
    protected ResponseSurveyDTO toResponseDTO(Survey survey) {
        return surveyMapper.toDTO(survey);
    }

    @Override
    protected void updateEntityFromDTO(UpdateSurveyDTO updateSurveyDTO, Survey survey) {
        surveyMapper.updateSurveyFromDto(updateSurveyDTO, survey);
    }

}
