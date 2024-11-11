package com.it.itlens.models.mappers;

import com.it.itlens.models.dtos.Answer.CreateAnswerDTO;
import com.it.itlens.models.dtos.Answer.ResponseAnswerDTO;
import com.it.itlens.models.dtos.Answer.UpdateAnswerDTO;
import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.mappers.helpers.QuestionMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",uses = {QuestionMapperHelper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AnswerMapper extends GenericMapper<Answer, CreateAnswerDTO, UpdateAnswerDTO, ResponseAnswerDTO> {

    @Override
    @Mapping(target = "question", source = "questionId")
    Answer toEntity(CreateAnswerDTO createAnswerDTO);

    @Override
    @Mapping(target = "question", source = "questionId")
    Answer updateEntityFromDTO(UpdateAnswerDTO updateDTO, @MappingTarget Answer entity);

    @Override
    @Mapping(target = "question", source = "question")
    ResponseAnswerDTO toDTO(Answer answer);
}
