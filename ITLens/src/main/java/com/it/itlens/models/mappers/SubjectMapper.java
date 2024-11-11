package com.it.itlens.models.mappers;

import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.mappers.helpers.SubjectMapperHelper;
import com.it.itlens.models.mappers.helpers.SurveyEditionMapperHelper;
import com.it.itlens.models.mappers.helpers.SurveyMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",uses = {SurveyEditionMapperHelper.class , SubjectMapperHelper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface SubjectMapper extends GenericMapper<Subject, CreateSubjectDTO, UpdateSubjectDTO, ResponseSubjectDTO> {
    @Override
    @Mapping(target = "surveyEdition", source = "surveyEditionId")
    @Mapping(target = "parentSubject", source = "parentSubjectId")
    Subject toEntity(CreateSubjectDTO createSubjectDTO);

    @Override
    @Mapping(target = "surveyEdition", source = "surveyEditionId")
    @Mapping(target = "parentSubject", source = "parentSubjectId")
    Subject updateEntityFromDTO(UpdateSubjectDTO updateDTO, @MappingTarget Subject entity);

    @Override
    @Mapping(target = "surveyEdition", source = "surveyEdition")
    @Mapping(target = "parentSubject", source = "parentSubject")
    ResponseSubjectDTO toDTO(Subject subject);
}
