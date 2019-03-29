package com.example.nhood.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.nhood.domain.Offer;
import com.example.nhood.service.OfferService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class OffersController {

  @Autowired
  OfferService offerService;


  @ApiOperation(value = "Add a offer")
  @RequestMapping(value = "/saveOffer", method = RequestMethod.POST, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully saved"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public Offer saveOffer(Offer offer) {
    offerService.saveOffer(offer);
    return offer;
  }

  @RequestMapping(value = "/welcome", method = RequestMethod.GET)
   public String welcome() {
     return "welcome";
   }
  
  @RequestMapping(value = "/getOffersByUid", method = RequestMethod.GET)
  public List<Offer> getOffers(@RequestParam String userId) {
    return  offerService.getOffers(userId);
  }

}
