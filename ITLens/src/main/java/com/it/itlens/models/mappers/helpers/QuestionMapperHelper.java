package com.it.itlens.models.mappers.helpers;

import com.it.itlens.models.entities.Question;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.repository.QuestionRepository;
import com.it.itlens.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapperHelper {

    @Autowired
    private QuestionRepository questionRepository;

    public Question mapQuestionIdToQuestion(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
}
