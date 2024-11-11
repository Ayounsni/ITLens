package com.it.itlens.controllers;

import com.it.itlens.models.dtos.Question.CreateQuestionDTO;
import com.it.itlens.models.dtos.Question.ResponseQuestionDTO;
import com.it.itlens.models.dtos.Question.UpdateQuestionDTO;
import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.entities.Question;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.services.implementation.QuestionService;
import com.it.itlens.services.implementation.SubjectService;
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
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<ResponseQuestionDTO> createQuestion(@Valid @RequestBody CreateQuestionDTO createQuestionDTO) {
        ResponseQuestionDTO question = questionService.create(createQuestionDTO);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseQuestionDTO> getQuestionById(@Exists(entity = Question.class , message = "Cette question n'existe pas.")  @PathVariable("id") Long id) {
            ResponseQuestionDTO question = questionService.findById(id);
            return new ResponseEntity<>(question, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ResponseQuestionDTO>> getAllQuestions() {
        List<ResponseQuestionDTO> questions = questionService.findAll();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@Exists(entity = Question.class , message = "Cette question n'existe pas.") @PathVariable("id") Long id) {
            questionService.deleteById(id);
            return new ResponseEntity<>("Question est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseQuestionDTO> updateSubject(@Exists(entity = Question.class , message = "Cet question n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateQuestionDTO updateQuestionDTO) {

            ResponseQuestionDTO updatedQuestion = questionService.update(id, updateQuestionDTO);
            return new ResponseEntity<>(updatedQuestion, HttpStatus.OK);
    }


}
