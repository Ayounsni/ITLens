package com.it.itlens.models.mappers;


import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.EmbeddableSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.mappers.helpers.OwnerMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {OwnerMapperHelper.class})
public interface SurveyMapper {

    @Mapping(target = "owner", source = "ownerId")
    Survey toEntity(CreateSurveyDTO createSurveyDTO);

    @Mapping(target = "owner", source = "owner")
    ResponseSurveyDTO toDTO(Survey survey);


    List<ResponseSurveyDTO> toDTOs(List<Survey> surveys);

    void updateSurveyFromDto(UpdateSurveyDTO updateSurveyDTO, @MappingTarget Survey survey);
}
