package com.it.itlens.services.interfaces;

import com.it.itlens.models.dtos.Participation.ParticipationDTO;

public interface ISurveyParticipationService {
    void saveParticipation(Long surveyId, ParticipationDTO participationDTO);
}
