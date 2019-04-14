package com.example.nhood.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.nhood.domain.Offer;
import com.example.nhood.service.OfferService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController

public class OffersController {

  @Autowired
  OfferService offerService;
  
  /*@Autowired
  ContentNegotiationManager contentNegotiationManager;
*/
  
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


  @ApiOperation(value = "Retrieve offers for a user")
  @RequestMapping(value = "/getOffersByUser/{userId}", method = RequestMethod.GET)
  public List<Offer> getOffers(@ApiParam("Offers pulled for UserId") @PathVariable String userId) {
    return offerService.getOffers(userId);
  }

  @ApiOperation(value = "Retrieve Offers for user")
  @RequestMapping(value = "/getOffers/{email}/offers", method = RequestMethod.GET)
  public List<Offer>  getOffersByUserEmail(@ApiParam(value="user email" , name="email" ) @PathVariable String email) {
    System.out.println("\n\n \n ---" + email);
    return  offerService.getOffersByEmail(email);
  }

  @ApiOperation(value="Retrieve all offers page by page")
  @GetMapping(value="/offers/all"  )  
  public List<Offer> getAllOffers ( @RequestParam (value="page") int page, @RequestParam (value="size") int size,
      @RequestParam (value="format") String format)
  {
    
    Pageable pageable = PageRequest.of(page, size); 
    return offerService.getAllOffers(pageable);
    
    
  }
}
