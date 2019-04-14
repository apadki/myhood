package com.example.nhood.domain;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import com.example.nhood.validators.PhoneNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class User {
  
 
  private String id;

  @NotNull (message= "First Name cannot be null")
  @Size(min =3, max =255)
  @NotBlank (message= "First Name cannot be blank")
  private String firstName;
  
  @NotNull (message= "Last Name cannot be null")
  @Size(min =3, max =255)
  @NotBlank (message= "Last Name cannot be blank")
  private String lastName;
  
  @NotNull
  @Email (message= "Email cannot be null")
  private String email;
  
  private Date createDate;
  
  private Date updateDate;
  
  private boolean working;
  
  @PhoneNumberConstraint (message = " Phone number must be a minimum of 9 numbers")
  private String phoneNumebr;

}
