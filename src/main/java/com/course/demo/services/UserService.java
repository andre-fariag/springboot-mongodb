package com.course.demo.services;

import java.util.List;
import java.util.Optional;

import com.course.demo.domain.User;
import com.course.demo.dto.UserDTO;
import com.course.demo.repository.UserRepository;
import com.course.demo.services.exception.ObjectNotfoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository repo; // dependecy injection by SpringBoot

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findById(String id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjectNotfoundException("Object not found!"));
  }

  public User insert(User obj) {
    return repo.insert(obj);
  }

  public void delete(String id) {
    findById(id); // this method will check if the id exists and therefore cach any exception
    repo.deleteById(id);
  }

  public User update(User obj) {
    User newObj = findById(obj.getId());
    updateData(newObj, obj);
    return repo.save(newObj);

  }

  private void updateData(User newObj, User obj) {
    newObj.setName(obj.getName());
    newObj.setEmail(obj.getEmail());

  }

  public User fromDTO(UserDTO objDTO) {
    return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
  }

}
