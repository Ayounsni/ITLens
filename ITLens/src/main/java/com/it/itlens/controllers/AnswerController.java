package com.it.itlens.controllers;

import com.it.itlens.models.dtos.Answer.CreateAnswerDTO;
import com.it.itlens.models.dtos.Answer.ResponseAnswerDTO;
import com.it.itlens.models.dtos.Answer.UpdateAnswerDTO;
import com.it.itlens.models.dtos.Pagination.PageDTO;
import com.it.itlens.models.dtos.Question.CreateQuestionDTO;
import com.it.itlens.models.dtos.Question.ResponseQuestionDTO;
import com.it.itlens.models.dtos.Question.UpdateQuestionDTO;
import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.entities.Question;
import com.it.itlens.services.implementation.AnswerService;
import com.it.itlens.services.implementation.QuestionService;
import com.it.itlens.validation.annotations.Exists;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<ResponseAnswerDTO> createAnswer(@Valid @RequestBody CreateAnswerDTO createAnswerDTO) {
        ResponseAnswerDTO answer = answerService.create(createAnswerDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAnswerDTO> getAnswerById(@Exists(entity = Answer.class , message = "Cette réponse n'existe pas.")  @PathVariable("id") Long id) {
            ResponseAnswerDTO answer = answerService.findById(id);
            return new ResponseEntity<>(answer, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<PageDTO<ResponseAnswerDTO>> getAllAnswersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        PageDTO<ResponseAnswerDTO> answers = answerService.findAll(page, size);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnswer(@Exists(entity = Answer.class , message = "Cette réponse n'existe pas.") @PathVariable("id") Long id) {
            answerService.deleteById(id);
            return new ResponseEntity<>("Question est supprimé avec succès", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseAnswerDTO> updateAnswer(@Exists(entity = Answer.class , message = "Cet réponse n'existe pas.") @PathVariable("id") Long id, @Valid @RequestBody UpdateAnswerDTO updateAnswerDTO) {

            ResponseAnswerDTO updatedAnswer = answerService.update(id, updateAnswerDTO);
            return new ResponseEntity<>(updatedAnswer, HttpStatus.OK);
    }


}
