package com.example.nhood.service;

import java.util.Date;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.User;
import com.example.nhood.entities.UserEntity;
import com.example.nhood.mappers.UserMapper;
import com.example.nhood.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;
  
  @Autowired
  UserRepository userRepository;
  
   
  @Override
  public User saveUser(User user) {
    user.setCreateDate(new Date());
    user.setUpdateDate(new Date());
    //System.out.println("  saveUser Service " + user);
    return userMapper.fromEntity(userRepository.save(userMapper.toEntity(user)));
  }
  
  /* (non-Javadoc)
   * @see com.example.nhood.service.IUserService#getUserByEmail(java.lang.String)
   */
  @Override
  public User getUserByEmail(String email) {
    return userMapper.fromEntity(userRepository.findByEmail(email));
  }

  @Override
  public User getUserById(String id) {    
  
    if(!StringUtils.isBlank(id)) {
      Integer id1 = Integer.valueOf(id);
      Optional<UserEntity> user1 = userRepository.findById(id1);
      if (user1.isPresent())  return userMapper.fromEntity(user1.get());
    }
    return null;
  }
}
