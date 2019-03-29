package com.example.nhood.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.nhood.entities.OfferEntity;

public interface OfferRepository extends CrudRepository<OfferEntity, Integer>{

  List<OfferEntity> findByUserId(Integer id);
  @Query("select ofr from OfferEntity ofr,  UserEntity user where ofr.userId=user.id and user.email=?1")
  List<OfferEntity> findFromUserEmail(String email);
}
