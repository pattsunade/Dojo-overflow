package com.patriciadelgado.ninjaoverflow.Repositories;

import java.util.List;
import java.util.Optional;

import com.patriciadelgado.ninjaoverflow.Models.Tag;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
      List<Tag> findAll();

      Optional<Tag> findBySubject(String subject);
}
