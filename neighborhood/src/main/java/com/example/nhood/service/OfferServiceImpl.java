package com.example.nhood.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.exceptions.OfferException;
import com.example.nhood.mappers.OfferMapper;
import com.example.nhood.repository.OfferRepository;
import lombok.Data;

@Service
@Data
public class OfferServiceImpl implements OfferService {

  @Autowired
  OfferMapper offerMapper;

  @Autowired
  OfferRepository offerRepository;

  /* (non-Javadoc)
   * @see com.example.nhood.service.IOfferService#saveOffer(com.example.nhood.domain.Offer)
   */
  @Override
  public Offer saveOffer(Offer offer) {

    
    offer.setCreateDate(new Date());
    offer.setUpdateDate(new Date());
    OfferEntity entity = offerRepository.save(offerMapper.toEntity(offer));
    return offerMapper.fromEntity(entity);
  }
  
  /* (non-Javadoc)
   * @see com.example.nhood.service.IOfferService#getOffers(java.lang.String)
   */
  @Override
  public List<Offer> getOffers(String userId) throws OfferException {
     if (!StringUtils.isBlank(userId)) {
       try {
       Integer uid = Integer.parseInt(userId);
       if (1 == 1) {
         OfferException.forNotFoundOffer("error.offer.not.found");
       }
       return offerRepository.findByUserId(uid).stream().map(e1->offerMapper.fromEntity(e1)).collect(Collectors.toList());
       }
       catch(DataAccessException dae) {
         OfferException.forNotFoundOffer("error.offer.not.found");
       }
       }
     return null;
  }
  
  
  @Override
  public List<Offer> getOffersByEmail(String email){
       return offerRepository.findFromUserEmail(email).stream().map(e1->offerMapper.fromEntity(e1)).collect(Collectors.toList());
  }

  @Override
  public List<Offer> getAllOffers(Pageable page) {
    Page<OfferEntity> page1 = offerRepository.findAll(page);
    List<OfferEntity> listEntity = new ArrayList<>();
    listEntity = page1.getContent();
    return listEntity.stream().map(e1->offerMapper.fromEntity(e1)).collect(Collectors.toList());
  }

}