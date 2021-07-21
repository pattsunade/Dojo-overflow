package com.patriciadelgado.ninjaoverflow.services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.ninjaoverflow.Models.Question;
import com.patriciadelgado.ninjaoverflow.Repositories.QuestionRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> allQuestion() {
        return questionRepository.findAll();
    }
    
    public Question findQuestion(Long id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
      public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }
}

