package com.example.nhood.service;

import com.example.nhood.domain.User;


public interface UserService {

  User saveUser(User user);

  User getUserByEmail(String email);

}
