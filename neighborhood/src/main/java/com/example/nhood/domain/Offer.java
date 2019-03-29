package com.example.nhood.domain;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Offer {

  @NotNull
  private String id;

  @NotNull
  private String name;

  @NotNull
  private String offerType;

  
  private Date createDate;

 
  private Date updateDate;

  
  
}
