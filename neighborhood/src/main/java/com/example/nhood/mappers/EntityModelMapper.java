package com.example.nhood.mappers;

import java.util.Optional;
import com.example.nhood.domain.Offer;
import com.example.nhood.domain.User;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.entities.UserEntity;

public interface EntityModelMapper <E, M>{
  E toEntity(M m);
  M fromEntity(E e);
 
 
}
