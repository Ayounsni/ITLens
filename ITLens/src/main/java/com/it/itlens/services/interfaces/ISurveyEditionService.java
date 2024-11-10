package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.dtos.SurveyEdition.CreateSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.UpdateSurveyEditionDTO;

public interface ISurveyEditionService extends IGenericService<CreateSurveyEditionDTO, UpdateSurveyEditionDTO, ResponseSurveyEditionDTO> {

}
