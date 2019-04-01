package com.example.nhood.domain;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
  
  @NotNull
  private String id;

  @NotNull
  @Size(min =3, max =255)
  private String firstName;
  
  @NotNull
  @Size(min =3, max =255)
  private String lastName;
  
  @NotNull
  @Email
  private String email;
  
  private Date createDate;
  
  private Date updateDate;

}
