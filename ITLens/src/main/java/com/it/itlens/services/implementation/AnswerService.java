package com.it.itlens.services.implementation;

import com.it.itlens.models.dtos.Answer.CreateAnswerDTO;
import com.it.itlens.models.dtos.Answer.ResponseAnswerDTO;
import com.it.itlens.models.dtos.Answer.UpdateAnswerDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.mappers.AnswerMapper;
import com.it.itlens.models.mappers.SurveyMapper;
import com.it.itlens.repository.AnswerRepository;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.IAnswerService;
import com.it.itlens.services.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

@Service
public class AnswerService extends GenericService<Answer, CreateAnswerDTO, UpdateAnswerDTO, ResponseAnswerDTO> implements IAnswerService {

    public AnswerService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        super(answerRepository,answerMapper);
    }

}
