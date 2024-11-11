package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Question.CreateQuestionDTO;
import com.it.itlens.models.dtos.Question.ResponseQuestionDTO;
import com.it.itlens.models.dtos.Question.UpdateQuestionDTO;
import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;

public interface IQuestionService extends IGenericService<CreateQuestionDTO, UpdateQuestionDTO, ResponseQuestionDTO> {

}
