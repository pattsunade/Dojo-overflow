package com.patriciadelgado.ninjaoverflow.Repositories;

import java.util.List;

import com.patriciadelgado.ninjaoverflow.Models.Answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
      List<Answer> findAll();
}
