package com.example.nhood.mappers;

import org.springframework.stereotype.Service;
import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.utils.HoodUtils;

@Service

public class OfferMapperImpl implements OfferMapper{
  
   
  HoodUtils hoodUtils = new HoodUtils();
 
  @Override
  public Offer fromEntity(OfferEntity entity) {
    
    Offer offer = new Offer();
    
    offer.setId(hoodUtils.fromInt(entity.getId()));
    offer.setName(entity.getName());
    offer.setOfferType(entity.getOfferType());
    offer.setUserId(hoodUtils.fromInt(entity.getUserId()));
    return offer;
  }

  @Override
  public OfferEntity toEntity(Offer model) {
    OfferEntity entity = new OfferEntity();
    entity.setName(model.getName());
    entity.setOfferType(model.getOfferType());
    entity.setCreateDate(model.getCreateDate());
    entity.setUpdateDate(model.getUpdateDate());
    entity.setUserId(model.getUserId() == null ? null : Integer.valueOf(model.getUserId()));
    return entity;
  }
}
