package com.patriciadelgado.ninjaoverflow.services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.ninjaoverflow.Models.Answer;
import com.patriciadelgado.ninjaoverflow.Repositories.AnswerRepository;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> allAnswer() {
        return answerRepository.findAll();
    }
    
    public Answer findAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            return optionalAnswer.get();
        } else {
            return null;
        }
    }
      public Answer createAnswer(Answer a) {
        return answerRepository.save(a);
    
	}
}
