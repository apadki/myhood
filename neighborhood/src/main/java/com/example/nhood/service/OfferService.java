package com.example.nhood.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.mappers.OfferMapper;
import com.example.nhood.repository.OfferRepository;

@Service

public class OfferService {

  @Autowired
  OfferMapper offerMapper;

  @Autowired
  OfferRepository offerRepository;

  public Offer saveOffer(Offer offer) {

    
    offer.setCreateDate(new Date());
    offer.setUpdateDate(new Date());
    OfferEntity entity = offerRepository.save(offerMapper.toEntity(offer));
    return offerMapper.fromEntity(entity);
  }
  
  public List<Offer> getOffers(String userId){
     if (!StringUtils.isBlank(userId)) {
       Integer uid = Integer.parseInt(userId);
       return offerRepository.findByUserId(uid).stream().map(e1->offerMapper.fromEntity(e1)).collect(Collectors.toList());
     }
     return null;
  }
  
  public List<Offer> getOffersByEmail(String email){
     
     
      return offerRepository.findFromUserEmail(email).stream().map(e1->offerMapper.fromEntity(e1)).collect(Collectors.toList());
    
    //return null;
 }

}