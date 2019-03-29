package com.example.nhood.mappers;

import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;

public interface EntityModelMapper <E, M>{
  E toEntity(M m);
  M fromEntity(E e);
 
}
