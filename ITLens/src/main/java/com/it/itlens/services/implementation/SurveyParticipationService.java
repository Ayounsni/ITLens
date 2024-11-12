package com.it.itlens.services.implementation;



import com.it.itlens.models.dtos.Participation.AnswerDTO;
import com.it.itlens.models.dtos.Participation.ParticipationDTO;
import com.it.itlens.models.dtos.Participation.ResponseDTO;
import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.entities.Question;
import com.it.itlens.models.enums.QuestionType;
import com.it.itlens.repository.AnswerRepository;
import com.it.itlens.repository.QuestionRepository;
import com.it.itlens.services.interfaces.ISurveyParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SurveyParticipationService implements ISurveyParticipationService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    @Transactional
    public void saveParticipation(Long surveyId, ParticipationDTO participationDTO) {
        for (ResponseDTO responseDTO : participationDTO.getResponses()) {
            Question question = questionRepository.findById(responseDTO.getQuestionId())
                    .orElseThrow(() -> new IllegalArgumentException("Question not found"));

            if (question.getSubject() == null) {
                throw new IllegalArgumentException("La question ID = " + question.getId() + " n'a pas de sujet associé.");
            }

            if (!question.getSubject().getSurveyEdition().getSurvey().getId().equals(surveyId)) {
                throw new IllegalArgumentException("La question " + responseDTO.getQuestionId() + " n'appartient pas au sondage " + surveyId);
            }

            if (question.getQuestionType() == QuestionType.SINGLE_CHOICE) {
                if (responseDTO.getSingleAnswerId() == null || responseDTO.getMultipleAnswers() != null) {
                    throw new IllegalArgumentException("Une seule réponse est requise pour la question à choix unique pour la question ID = " + question.getId());
                }

                Answer answer = answerRepository.findById(responseDTO.getSingleAnswerId())
                        .orElseThrow(() -> new IllegalArgumentException("Answer not found"));

                if (!answer.getQuestion().getId().equals(question.getId())) {
                    throw new IllegalArgumentException("La réponse ID = " + responseDTO.getSingleAnswerId() + " n'appartient pas à la question ID = " + question.getId());
                }

                answer.incrementSelectionCount();
                answerRepository.save(answer);

                question.incrementAnswerCount();
                questionRepository.save(question);

            } else if (question.getQuestionType() == QuestionType.MULTIPLE_CHOICE) {
                if (responseDTO.getMultipleAnswers() == null || responseDTO.getSingleAnswerId() != null) {
                    throw new IllegalArgumentException("Des réponses multiples sont requises pour la question à choix multiple pour la question ID = " + question.getId());
                }

                for (AnswerDTO answerDTO : responseDTO.getMultipleAnswers()) {
                    Answer answer = answerRepository.findById(answerDTO.getAnswerId())
                            .orElseThrow(() -> new IllegalArgumentException("Answer not found"));

                    if (!answer.getQuestion().getId().equals(question.getId())) {
                        throw new IllegalArgumentException("La réponse ID = " + answerDTO.getAnswerId() + " n'appartient pas à la question ID = " + question.getId());
                    }

                    answer.incrementSelectionCount();
                    answerRepository.save(answer);

                    question.incrementAnswerCount();
                    questionRepository.save(question);
                }
            }
        }
    }
}

