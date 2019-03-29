package com.example.nhood.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.utils.HoodUtils;

@Service

public class OfferMapperImpl implements OfferMapper{
  
  @Autowired
  HoodUtils hoodUtils;
 
  @Override
  public Offer fromEntity(OfferEntity entity) {
    
    Offer offer = new Offer();
    
    offer.setId(hoodUtils.fromInt(entity.getId()));
    offer.setName(entity.getName());
    offer.setOfferType(entity.getOfferType());
    return offer;
  }

  @Override
  public OfferEntity toEntity(Offer model) {
    // TODO Auto-generated method stub
    OfferEntity entity = new OfferEntity();
    entity.setName(model.getName());
    entity.setOfferType(model.getOfferType());
    entity.setCreateDate(model.getCreateDate());
    entity.setUpdateDate(model.getUpdateDate());
  
    
    return entity;
  }

}
