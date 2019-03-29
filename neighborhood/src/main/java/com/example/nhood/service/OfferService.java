package com.example.nhood.service;

import java.util.List;
import com.example.nhood.domain.Offer;


public interface OfferService {

  Offer saveOffer(Offer offer);

  List<Offer> getOffers(String userId);

  List<Offer> getOffersByEmail(String email);

}
