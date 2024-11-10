package com.it.itlens.controllers;

import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.dtos.SurveyEdition.CreateSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.UpdateSurveyEditionDTO;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.services.implementation.SurveyEditionService;
import com.it.itlens.services.implementation.SurveyService;
import com.it.itlens.validation.annotations.Exists;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/surveyEdition")
public class SurveyEditionController {
    @Autowired
    private SurveyEditionService surveyEditionService;

    @PostMapping
    public ResponseEntity<ResponseSurveyEditionDTO> createSurveyEdition(@Valid @RequestBody CreateSurveyEditionDTO createSurveyEditionDTO) {
        ResponseSurveyEditionDTO survey = surveyEditionService.create(createSurveyEditionDTO);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSurveyEditionDTO> getSurveyEditionById(@Exists(entity = SurveyEdition.class , message = "Cet surveyEdition n'existe pas.")  @PathVariable("id") Long id) {
            ResponseSurveyEditionDTO surveyEdition = surveyEditionService.findById(id);
            return new ResponseEntity<>(surveyEdition, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ResponseSurveyEditionDTO>> getAllSurveyEditions() {
        List<ResponseSurveyEditionDTO> surveyEditions = surveyEditionService.findAll();
        return new ResponseEntity<>(surveyEditions, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@Exists(entity = SurveyEdition.class , message = "Cet surveyEdition n'existe pas.") @PathVariable("id") Long id) {
            surveyEditionService.deleteById(id);
            return new ResponseEntity<>("SurveyEdition est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSurveyEditionDTO> updateSurvey(@Exists(entity = SurveyEdition.class , message = "Cet surveyEdition n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateSurveyEditionDTO updateSurveyEditionDTO) {

            ResponseSurveyEditionDTO updatedSurveyEdition = surveyEditionService.update(id, updateSurveyEditionDTO);
            return new ResponseEntity<>(updatedSurveyEdition, HttpStatus.OK);
    }


}
