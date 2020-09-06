package com.course.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.course.demo.domain.Post;
import com.course.demo.repository.PostRepository;
import com.course.demo.services.exception.ObjectNotfoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    Optional<Post> user = repo.findById(id);
    return user.orElseThrow(() -> new ObjectNotfoundException("Object not found!"));
  }

  public List<Post> findByTitle(String text) {
    return repo.searchTitle(text);
  }

  public List<Post> fullSearch(String text, Date dateMin, Date dateMax) {
    dateMax = new Date(dateMax.getTime() + 24 * 60 * 60 * 100); // finishes the search at the end of the day instead of
                                                                // the beginnig
    return repo.fullSearch(text, dateMin, dateMax);
  }
}
