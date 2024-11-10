package com.it.itlens.models.mappers;


import com.it.itlens.models.dtos.SurveyEdition.CreateSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.UpdateSurveyEditionDTO;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.models.mappers.helpers.SurveyMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",uses = {SurveyMapperHelper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface SurveyEditionMapper extends GenericMapper<SurveyEdition, CreateSurveyEditionDTO, UpdateSurveyEditionDTO, ResponseSurveyEditionDTO>  {

    @Override
    @Mapping(target = "survey", source = "surveyId")
    SurveyEdition toEntity(CreateSurveyEditionDTO createSurveyEditionDTO);

    @Override
    @Mapping(target = "survey", source = "surveyId")
    SurveyEdition updateEntityFromDTO(UpdateSurveyEditionDTO updateDTO, @MappingTarget SurveyEdition entity);

    @Override
    @Mapping(target = "survey", source = "survey")
    ResponseSurveyEditionDTO toDTO(SurveyEdition surveyEdition);

}
