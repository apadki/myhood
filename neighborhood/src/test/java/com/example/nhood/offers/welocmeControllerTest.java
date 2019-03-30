package com.example.nhood.offers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.nhood.controller.WelcomeController;
import com.example.nhood.service.OfferService;

@RunWith(SpringRunner.class)
@WebMvcTest(WelcomeController.class)


public class welocmeControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
    
  @Test
  public void welcomeTest() throws Exception {
    RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
        .accept(MediaType.APPLICATION_JSON);
    MvcResult result =  mockMvc.perform(request).andExpect(status().isOk())
        .andReturn();
    assertEquals("welcome", result.getResponse().getContentAsString());
    
  }


}
