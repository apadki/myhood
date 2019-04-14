package com.example.nhood.service;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.User;
import com.example.nhood.entities.UserEntity;
import com.example.nhood.exceptions.UserException;
import com.example.nhood.mappers.UserMapper;
import com.example.nhood.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  @Autowired
  UserRepository userRepository;


  @Override
  public User saveUser(User user) throws UserException {
    user.setCreateDate(new Date());
    user.setUpdateDate(new Date());
  
    user.setWorking(true);

    // System.out.println(" saveUser Service " + user);
    // if (1 == 1) throw new HoodExceptionResponse ();
    try {
      return userMapper.fromEntity(userRepository.save(userMapper.toEntity(user)));
    } catch (DataAccessException ex) {
        UserException.forUserDataAccessException(ex.getMessage());
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.example.nhood.service.IUserService#getUserByEmail(java.lang.String)
   */
  @Override
  public User getUserByEmail(String email) {
    return userMapper.fromEntity(userRepository.findByEmail(email));
  }

  @Override
  public User getUserById(String id) {

    if (!StringUtils.isBlank(id)) {
      Integer id1 = Integer.valueOf(id);
      UserEntity user1 = userRepository.findById(id1).orElse(null);
      return userMapper.fromEntity(user1);
    }
    return null;
  }

  @Override
  public boolean isValidUser(String id) {
    if (!StringUtils.isBlank(id)) {
      return userRepository.existsById(Integer.parseInt(id));
    }
    return false;
  }
  
  
}
