package com.it.itlens.controllers;


import com.it.itlens.models.dtos.Participation.ParticipationDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.services.implementation.SurveyParticipationService;
import com.it.itlens.validation.annotations.Exists;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/surveys")
public class SurveyParticipationController {

    @Autowired
    private SurveyParticipationService surveyParticipationService;

    @PostMapping("/{id}/participate")
    public ResponseEntity<String> participateSurvey(@Exists(entity = Survey.class , message = "Cet survey n'existe pas.") @PathVariable("id") Long surveyId,
                                                    @RequestBody @Valid ParticipationDTO participationDTO) {
        surveyParticipationService.saveParticipation(surveyId, participationDTO);
        return new ResponseEntity<>("Participation enregistrée avec succès", HttpStatus.OK);
    }
}
