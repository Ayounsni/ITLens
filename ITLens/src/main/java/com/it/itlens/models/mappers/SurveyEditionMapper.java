package com.it.itlens.models.mappers;


import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.entities.SurveyEdition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface SurveyEditionMapper {

    ResponseSurveyEditionDTO toDTO(SurveyEdition surveyEdition);
}
