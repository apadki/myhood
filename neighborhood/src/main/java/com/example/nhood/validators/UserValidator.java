package com.example.nhood.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.nhood.service.UserService;

public class UserValidator implements ConstraintValidator<ValidUser, String>{
  
  @Autowired
  UserService userService;
  
  @Override
  public void initialize(ValidUser userid) {
  }

  @Override
  public boolean isValid(String userid, ConstraintValidatorContext cvctx) {
    return userService.isValidUser(userid);
  }   
}