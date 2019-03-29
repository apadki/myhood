package com.example.nhood.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.User;
import com.example.nhood.mappers.UserMapper;
import com.example.nhood.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;
  
  @Autowired
  UserRepository userRepository;
  
  /* (non-Javadoc)
   * @see com.example.nhood.service.IUserService#saveUser(com.example.nhood.domain.User)
   */
  @Override
  public User saveUser(User user) {
    user.setCreateDate(new Date());
    user.setUpdateDate(new Date());
    return userMapper.fromEntity(userRepository.save(userMapper.toEntity(user)));
  }
  
  /* (non-Javadoc)
   * @see com.example.nhood.service.IUserService#getUserByEmail(java.lang.String)
   */
  @Override
  public User getUserByEmail(String email) {
    return userMapper.fromEntity(userRepository.findByEmail(email));
  }
}
