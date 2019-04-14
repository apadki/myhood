package com.example.nhood.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import com.example.nhood.domain.Offer;
import com.example.nhood.exceptions.OfferException;


public interface OfferService {

  Offer saveOffer(Offer offer);

  List<Offer> getOffers(String userId) throws OfferException;

  List<Offer> getOffersByEmail(String email);
  
  List<Offer> getAllOffers(Pageable page);

}
