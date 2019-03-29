package com.example.nhood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "user")
@EqualsAndHashCode(callSuper=false)
public class UserEntity extends BaseEntity{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @Column (name = "first_name", nullable=false, length =255)
  private String firstName;
  
  @Column (name = "last_name", nullable=false, length =255)
  private String lastName;
  
  @Column (name = "email", nullable=false, length =20)
  private String email;
  
  
}
