package com.it.itlens.controllers;

import com.it.itlens.models.dtos.Pagination.PageDTO;
import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.dtos.SurveyEdition.CreateSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.ResponseSurveyEditionDTO;
import com.it.itlens.models.dtos.SurveyEdition.UpdateSurveyEditionDTO;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.services.implementation.SubjectService;
import com.it.itlens.services.implementation.SurveyEditionService;
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
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<ResponseSubjectDTO> createSubject(@Valid @RequestBody CreateSubjectDTO createSubjectDTO) {
        ResponseSubjectDTO subject = subjectService.create(createSubjectDTO);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSubjectDTO> getSubjectById(@Exists(entity = Subject.class , message = "Cet subject n'existe pas.")  @PathVariable("id") Long id) {
            ResponseSubjectDTO subject = subjectService.findById(id);
            return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PageDTO<ResponseSubjectDTO>> getAllSubjectsPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        PageDTO<ResponseSubjectDTO> subjects = subjectService.findAll(page, size);
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSubject(@Exists(entity = Subject.class , message = "Cet subject n'existe pas.") @PathVariable("id") Long id) {
            subjectService.deleteById(id);
            return new ResponseEntity<>("Subject est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseSubjectDTO> updateSubject(@Exists(entity = Subject.class , message = "Cet subject n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateSubjectDTO updateSubjectDTO) {

            ResponseSubjectDTO updatedSubject = subjectService.update(id, updateSubjectDTO);
            return new ResponseEntity<>(updatedSubject, HttpStatus.OK);
    }


}
