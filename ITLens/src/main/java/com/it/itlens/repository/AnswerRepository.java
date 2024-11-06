package com.it.itlens.repository;

import com.it.itlens.models.entities.Answer;
import com.it.itlens.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
