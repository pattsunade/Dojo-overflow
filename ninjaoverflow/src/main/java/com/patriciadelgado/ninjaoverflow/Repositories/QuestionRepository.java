package com.patriciadelgado.ninjaoverflow.Repositories;

import java.util.List;

import com.patriciadelgado.ninjaoverflow.Models.Question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
      List<Question> findAll();
}
