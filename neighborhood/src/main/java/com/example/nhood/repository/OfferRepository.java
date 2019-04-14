package com.example.nhood.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.nhood.entities.OfferEntity;


public interface OfferRepository extends CrudRepository<OfferEntity, Integer>{

  List<OfferEntity> findByUserId(Integer id);
  
  @Query("SELECT ofr FROM OfferEntity ofr,  UserEntity user WHERE ofr.userId=user.id and user.email=?1")
  List<OfferEntity> findFromUserEmail(String email);
  
  Page<OfferEntity> findAll(Pageable page);
}
