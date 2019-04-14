package com.example.nhood.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String>{
  
  
  @Override
  public void initialize(PhoneNumberConstraint contactNumber) {
  }

  @Override
  public boolean isValid(String phone, ConstraintValidatorContext cvctx) {
    return validatePhone(phone);
  }
  
  
  private boolean validatePhone(String phone) {
    return ! StringUtils.isBlank(phone) && phone.replace(" ", "").replace("-", "").matches("\\d{10}") ;
  }
}
