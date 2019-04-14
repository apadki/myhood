package com.example.nhood.service;

import com.example.nhood.domain.User;
import com.example.nhood.exceptions.UserException;


public interface UserService {

  User saveUser(User user) throws UserException;

  User getUserByEmail(String email);
  
  User getUserById(String id);
  
  boolean isValidUser(String id);
}
