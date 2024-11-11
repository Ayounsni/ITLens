package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;

public interface ISubjectService extends IGenericService<CreateSubjectDTO, UpdateSubjectDTO, ResponseSubjectDTO> {

}
