package com.example.nhood.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.nhood.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{
  
   UserEntity findByEmail(String email);

}
