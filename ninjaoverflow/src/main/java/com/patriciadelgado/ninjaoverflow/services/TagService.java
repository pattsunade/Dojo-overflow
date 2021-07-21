package com.patriciadelgado.ninjaoverflow.services;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.ninjaoverflow.Models.Tag;
import com.patriciadelgado.ninjaoverflow.Repositories.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class TagService {
    private final TagRepository tagRepository;

    
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> allTag() {
        return tagRepository.findAll();
    }
    
    public Tag findTag(String subject) {
        Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
        if (optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
     public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
