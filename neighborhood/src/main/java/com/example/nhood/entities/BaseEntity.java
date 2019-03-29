package com.example.nhood.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
  
  @Column(name ="update_date")
  @Temporal(TemporalType.DATE)
  private Date updateDate;
  
  @Column(name ="create_date")
  @Temporal(TemporalType.DATE)
  private Date createDate;


}
