package com.it.itlens.services.implementation;

import com.it.itlens.models.dtos.Results.ChapterResultDTO;
import com.it.itlens.models.dtos.Results.SubChapterResultDTO;
import com.it.itlens.models.dtos.Results.SurveyResultDTO;
import com.it.itlens.models.entities.*;
import com.it.itlens.repository.AnswerRepository;
import com.it.itlens.repository.QuestionRepository;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.ISurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SurveyResultService implements ISurveyResultService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyResultDTO getSurveyResults(Long surveyId) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new IllegalArgumentException("Survey not found"));

        SurveyResultDTO surveyResult = new SurveyResultDTO();
        surveyResult.setSurveyTitle(survey.getTitle());
        List<ChapterResultDTO> chapters = new ArrayList<>();

        for (SurveyEdition surveyEdition : survey.getSurveyEditions()) {
            for (Subject subject : surveyEdition.getSubjects()) {
                ChapterResultDTO chapterResult = new ChapterResultDTO();
                chapterResult.setTitle(subject.getTitle());

                chapterResult.setSubChapters(buildSubChapters(subject));
                chapters.add(chapterResult);
            }
        }

        surveyResult.setChapters(chapters);
        return surveyResult;
    }

    private List<SubChapterResultDTO> buildSubChapters(Subject subject) {
        List<SubChapterResultDTO> subChapters = new ArrayList<>();

        for (Subject subSubject : subject.getSubSubjects()) {
            for (Question question : subSubject.getQuestions()) {
                subChapters.add(buildSubChapterResult(subSubject, question));
            }
        }

        return subChapters;
    }

    private SubChapterResultDTO buildSubChapterResult(Subject subSubject, Question question) {
        SubChapterResultDTO subChapterResult = new SubChapterResultDTO();
        subChapterResult.setTitle(subSubject.getTitle());
        subChapterResult.setQuestion(question.getText());

        Map<String, Integer> answerCounts = new HashMap<>();
        for (Answer answer : question.getAnswers()) {
            answerCounts.put(answer.getText(), answer.getSelectionCount());
        }

        subChapterResult.setAnswers(answerCounts);
        subChapterResult.setTotalAnswers(question.getAnswerCount());

        return subChapterResult;
    }
}

