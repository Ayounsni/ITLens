package com.it.itlens.models.mappers;

import com.it.itlens.models.dtos.Question.CreateQuestionDTO;
import com.it.itlens.models.dtos.Question.ResponseQuestionDTO;
import com.it.itlens.models.dtos.Question.UpdateQuestionDTO;
import com.it.itlens.models.entities.Question;
import com.it.itlens.models.mappers.helpers.SubjectMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",uses = {SubjectMapperHelper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface QuestionMapper extends GenericMapper<Question, CreateQuestionDTO, UpdateQuestionDTO, ResponseQuestionDTO> {
    @Override
    @Mapping(target = "subject", source = "subjectId")
    Question toEntity(CreateQuestionDTO createQuestionDTO);

    @Override
    @Mapping(target = "subject", source = "subjectId")
    Question updateEntityFromDTO(UpdateQuestionDTO updateDTO, @MappingTarget Question entity);

    @Override
    @Mapping(target = "subject", source = "subject")
    ResponseQuestionDTO toDTO(Question question);
}
