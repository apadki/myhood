package com.example.nhood.offers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.example.nhood.domain.Offer;
import com.example.nhood.entities.OfferEntity;
import com.example.nhood.mappers.OfferMapper;
import com.example.nhood.mappers.OfferMapperImpl;
import com.example.nhood.repository.OfferRepository;
import com.example.nhood.service.OfferServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OfferServiceTest {
  
  @InjectMocks
  OfferServiceImpl offerService ;
  
  @Mock
  private OfferRepository offerRepository;
   
  OfferMapper offerMapper = new OfferMapperImpl();
  
  @Before
  public void before() {
    
  }
  
  @Test
  public void getOffersForUserEmail() {
    
   List<OfferEntity> offers = new ArrayList<>();
   OfferEntity entity = new OfferEntity();
   entity.setName("Offer1");
   entity.setId(1);
   entity.setOfferType("s");
   entity.setUserId(1);
   offers.add(entity);
   ReflectionTestUtils.setField(offerService, "offerMapper", offerMapper);
   when(offerRepository.findFromUserEmail(ArgumentMatchers.anyString())).thenReturn(offers);   
   
   List<Offer> offersFromService = offerService.getOffersByEmail("ABC");
   assertTrue(null, offersFromService.size() > 0);
  
  }

}
