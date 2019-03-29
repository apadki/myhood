package com.example.nhood.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.User;
import com.example.nhood.mappers.UserMapper;
import com.example.nhood.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserMapper userMapper;
  
  @Autowired
  UserRepository userRepository;
  
  public User saveUser(User user) {
    user.setCreateDate(new Date());
    user.setUpdateDate(new Date());
    return userMapper.fromEntity(userRepository.save(userMapper.toEntity(user)));
  }
  
  public User getUserByEmail(String email) {
    return userMapper.fromEntity(userRepository.findByEmail(email));
  }
}
