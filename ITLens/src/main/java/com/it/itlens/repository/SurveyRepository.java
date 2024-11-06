package com.it.itlens.repository;

import com.it.itlens.models.entities.Owner;
import com.it.itlens.models.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
