package com.example.nhood.offers;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.nhood.domain.User;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class UserControllerTest {
   @LocalServerPort
   private int port;
   @Autowired
   private TestRestTemplate restTemplate;
    
    @Test
    public void userByEmail() {
      User user = this.restTemplate.getForObject("http://localhost:" + port+"/getUser/anuradha@sahar.com" , User.class);
      assertEquals("anuradha@sahar.com", user.getEmail());
  }

}
