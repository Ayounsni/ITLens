package com.it.itlens.controllers;

import com.it.itlens.models.dtos.Owner.CreateOwnerDTO;
import com.it.itlens.models.dtos.Owner.ResponseOwnerDTO;
import com.it.itlens.models.dtos.Owner.UpdateOwnerDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.services.implementation.OwnerService;
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
@RequestMapping("/api/survey")
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<ResponseSurveyDTO> createSurvey(@Valid @RequestBody CreateSurveyDTO createSurveyDTO) {
        ResponseSurveyDTO survey = surveyService.create(createSurveyDTO);
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSurveyDTO> getSurveyById(@Exists(entity = Survey.class , message = "Cet survey n'existe pas.")  @PathVariable("id") Long id) {
            ResponseSurveyDTO survey = surveyService.findById(id);
            return new ResponseEntity<>(survey, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ResponseSurveyDTO>> getAllSurveys() {
        List<ResponseSurveyDTO> surveys = surveyService.findAll();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurvey(@Exists(entity = Survey.class , message = "Cet survey n'existe pas.") @PathVariable("id") Long id) {
            surveyService.deleteById(id);
            return new ResponseEntity<>("Survey est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSurveyDTO> updateSurvey(@Exists(entity = Survey.class , message = "Cet survey n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateSurveyDTO updateSurveyDTO) {

            ResponseSurveyDTO updatedSurvey = surveyService.update(id, updateSurveyDTO);
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
    }


}
