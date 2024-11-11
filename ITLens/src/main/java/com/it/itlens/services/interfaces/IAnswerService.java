package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Answer.CreateAnswerDTO;
import com.it.itlens.models.dtos.Answer.ResponseAnswerDTO;
import com.it.itlens.models.dtos.Answer.UpdateAnswerDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;

public interface IAnswerService extends IGenericService<CreateAnswerDTO, UpdateAnswerDTO, ResponseAnswerDTO> {

}
