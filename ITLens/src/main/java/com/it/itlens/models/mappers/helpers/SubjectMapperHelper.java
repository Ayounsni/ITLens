package com.it.itlens.models.mappers.helpers;

import com.it.itlens.models.entities.Subject;
import com.it.itlens.models.entities.SurveyEdition;
import com.it.itlens.repository.SubjectRepository;
import com.it.itlens.repository.SurveyEditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperHelper {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject mapSubjectIdToSubject(Long subjectId) {
        if (subjectId == null) {
            return null;
        }
        return subjectRepository.findById(subjectId).orElse(null);
    }
}
