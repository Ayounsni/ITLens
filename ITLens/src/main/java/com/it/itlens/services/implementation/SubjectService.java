package com.it.itlens.services.implementation;

import com.it.itlens.models.dtos.Subject.CreateSubjectDTO;
import com.it.itlens.models.dtos.Subject.ResponseSubjectDTO;
import com.it.itlens.models.dtos.Subject.UpdateSubjectDTO;
import com.it.itlens.models.dtos.Survey.CreateSurveyDTO;
import com.it.itlens.models.dtos.Survey.ResponseSurveyDTO;
import com.it.itlens.models.dtos.Survey.UpdateSurveyDTO;
import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.Survey;
import com.it.itlens.models.mappers.SubjectMapper;
import com.it.itlens.models.mappers.SurveyMapper;
import com.it.itlens.repository.SubjectRepository;
import com.it.itlens.repository.SurveyRepository;
import com.it.itlens.services.interfaces.ISubjectService;
import com.it.itlens.services.interfaces.ISurveyService;
import org.springframework.stereotype.Service;

@Service
public class SubjectService extends GenericService<Subject, CreateSubjectDTO, UpdateSubjectDTO, ResponseSubjectDTO> implements ISubjectService {

    public SubjectService(SubjectRepository subjectRepository , SubjectMapper subjectMapper) {
        super(subjectRepository , subjectMapper);
    }

}
