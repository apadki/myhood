package com.example.nhood.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SuppressWarnings("serial")
public class OfferException extends ResponseStatusException {

  public OfferException(HttpStatus status, String reason) {
    super(status, reason);
     
  }

  public static void forNotFoundOffer( String reason) {
      throw new OfferException (HttpStatus.NOT_FOUND, reason);
  }
   
}
