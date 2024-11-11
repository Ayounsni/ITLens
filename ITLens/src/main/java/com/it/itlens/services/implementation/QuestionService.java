package com.it.itlens.services.implementation;

import com.it.itlens.models.dtos.Question.CreateQuestionDTO;
import com.it.itlens.models.dtos.Question.ResponseQuestionDTO;
import com.it.itlens.models.dtos.Question.UpdateQuestionDTO;
import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.entities.Question;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.mappers.QuestionMapper;
import com.it.itlens.models.mappers.SubjectMapper;
import com.it.itlens.repository.QuestionRepository;
import com.it.itlens.repository.SubjectRepository;
import com.it.itlens.services.interfaces.IQuestionService;
import com.it.itlens.services.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends GenericService<Question, CreateQuestionDTO, UpdateQuestionDTO, ResponseQuestionDTO> implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionMapper questionMapper) {
        super(questionRepository, questionMapper);
    }
    @Override
    public ResponseQuestionDTO create(CreateQuestionDTO createQuestionDTO) {
        Long subjectId = createQuestionDTO.getSubjectId();
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Le subject avec cet ID n'existe pas."));

        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("Impossible d'ajouter une question à un subject qui possède des sous-sujets.");
        }

        Question question = questionMapper.toEntity(createQuestionDTO);
        question.setSubject(subject);

        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDTO(savedQuestion);
    }

    @Override
    public ResponseQuestionDTO update(Long id, UpdateQuestionDTO updateQuestionDTO) {
        Question existingQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La question avec cet ID n'existe pas."));

        Subject subject = existingQuestion.getSubject();

        if (subject.getSubSubjects() != null && !subject.getSubSubjects().isEmpty()) {
            throw new IllegalStateException("Impossible de mettre à jour une question dans un subject qui possède des sous-sujets.");
        }

        existingQuestion = questionMapper.updateEntityFromDTO(updateQuestionDTO, existingQuestion);

        Question updatedQuestion = questionRepository.save(existingQuestion);

        return questionMapper.toDTO(updatedQuestion);
    }


}
