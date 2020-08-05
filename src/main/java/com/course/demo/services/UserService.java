package com.course.demo.services;

import java.util.List;

import com.course.demo.domain.User;
import com.course.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo; // dependecy injection by SpringBoot

    public List<User> findAll() {
        return repo.findAll();
    }

}