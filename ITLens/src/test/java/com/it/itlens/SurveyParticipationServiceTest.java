package com.it.itlens;

import com.it.itlens.models.dtos.Participation.AnswerDTO;
import com.it.itlens.models.dtos.Participation.ParticipationDTO;
import com.it.itlens.models.dtos.Participation.ResponseDTO;
import com.it.itlens.models.entities.*;
import com.it.itlens.models.enums.QuestionType;
import com.it.itlens.repository.AnswerRepository;
import com.it.itlens.repository.QuestionRepository;
import com.it.itlens.services.implementation.SurveyParticipationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SurveyParticipationServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private SurveyParticipationService surveyParticipationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveParticipation_singleChoiceQuestion_validAnswer() {
        // Arrange
        Long surveyId = 1L;
        ParticipationDTO participationDTO = new ParticipationDTO();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setQuestionId(1L);
        responseDTO.setSingleAnswerId(2L);
        participationDTO.setResponses(List.of(responseDTO));

        Question question = new Question();
        question.setId(1L);
        question.setQuestionType(QuestionType.SINGLE_CHOICE);
        question.setSubject(mockSubjectWithSurveyId(surveyId));

        Answer answer = new Answer();
        answer.setId(2L);
        answer.setQuestion(question);

        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));
        when(answerRepository.findById(2L)).thenReturn(Optional.of(answer));

        // Act
        surveyParticipationService.saveParticipation(surveyId, participationDTO);

        // Assert
        verify(answerRepository, times(1)).save(answer);
        verify(questionRepository, times(1)).save(question);
    }


    @Test
    void testSaveParticipation_questionNotFound_shouldThrowException() {
        // Arrange
        Long surveyId = 1L;
        ParticipationDTO participationDTO = new ParticipationDTO();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setQuestionId(1L);
        participationDTO.setResponses(List.of(responseDTO));

        when(questionRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                surveyParticipationService.saveParticipation(surveyId, participationDTO));
    }

    @Test
    void testSaveParticipation_subjectNotFound_shouldThrowException() {
        // Arrange
        Long surveyId = 1L;
        ParticipationDTO participationDTO = new ParticipationDTO();
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setQuestionId(1L);
        participationDTO.setResponses(List.of(responseDTO));

        Question question = new Question();
        question.setId(1L);
        question.setQuestionType(QuestionType.SINGLE_CHOICE);

        when(questionRepository.findById(1L)).thenReturn(Optional.of(question));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () ->
                surveyParticipationService.saveParticipation(surveyId, participationDTO));
    }

    private Subject mockSubjectWithSurveyId(Long surveyId) {
        var subject = mock(Subject.class);
        var surveyEdition = mock(SurveyEdition.class);
        var survey = mock(Survey.class);

        when(subject.getSurveyEdition()).thenReturn(surveyEdition);
        when(surveyEdition.getSurvey()).thenReturn(survey);
        when(survey.getId()).thenReturn(surveyId);

        return subject;
    }
}

