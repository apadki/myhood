package com.example.nhood.offers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
   
  @Mock
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
   when(offerRepository.findFromUserEmail(ArgumentMatchers.anyString())).thenReturn(offers);   
   
   List<Offer> offersFromService = offerService.getOffersByEmail("ABC");
   verify(offerRepository, times(1)).findFromUserEmail(ArgumentMatchers.anyString());
   verify(offerRepository, atLeastOnce()).findFromUserEmail(ArgumentMatchers.anyString());
   verify(offerRepository, atLeast(1)).findFromUserEmail(ArgumentMatchers.anyString());
   verify(offerRepository, atMost(1)).findFromUserEmail(ArgumentMatchers.anyString());
   verify(offerRepository, never()).findByUserId(ArgumentMatchers.anyInt());
   
   ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
   verify(offerRepository).findFromUserEmail(captor.capture());
   
   assertEquals("ABC", captor.getValue());
   
   assertTrue(offersFromService.size() > 0);
   
  }

}
