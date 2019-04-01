package com.example.nhood.mappers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.User;
import com.example.nhood.entities.UserEntity;
import com.example.nhood.utils.HoodUtils;

@Service
public class UserMapperImpl implements UserMapper{
  
  @Autowired
  HoodUtils hoodUtils;

  @Override
  public UserEntity toEntity(User m) {
    if (m == null) {
      return null;
    }
    UserEntity entity = new UserEntity();
    entity.setEmail(m.getEmail());
    entity.setFirstName(m.getFirstName());
    entity.setLastName(m.getLastName());
    entity.setCreateDate(m.getCreateDate());
    entity.setUpdateDate(m.getUpdateDate());
    
    return entity;
    
  }

  @Override
  public User fromEntity(UserEntity e) {
    // TODO Auto-generated method stub
    if (e == null) return null;
    User user = new User();
    user.setId(hoodUtils.fromInt(e.getId()));
    user.setEmail(e.getEmail());
    user.setFirstName(e.getFirstName());
    user.setLastName(e.getLastName());
    user.setCreateDate(e.getCreateDate());
    user.setUpdateDate(e.getUpdateDate());
    return user;
    
  }

 

}
