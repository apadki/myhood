package com.example.nhood.offers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import com.example.nhood.controller.UserController;
import com.example.nhood.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(properties = "spring.http.encoding.enabled=false")
@RunWith(SpringRunner.class)
public class UserControllerTest1 {

  private MockMvc mockMvc;
  @Autowired
  protected WebApplicationContext wac;
  @Autowired
  UserController userController;

  @Before
  public void before() {
    this.mockMvc = standaloneSetup(this.userController).build();
  }

  @Test
  public void userByEmail() throws Exception {

    MvcResult result =
        mockMvc.perform(get("/getUserId/101")).andExpect(status().isOk()).andReturn();
    ObjectMapper mapper = new ObjectMapper();

    String json = result.getResponse().getContentAsString();
    User user = mapper.readValue(json, User.class);


    System.out.println("\n\n\n --- MOCKMVC: " + result.getResponse().getContentAsString());
    System.out.println("\n\n\n --- MOCKMVC User: " + user);

  }

  @Test
  public void saveUser() throws Exception {

    User user = new User();
    // user.setEmail("a@b.com");
    user.setFirstName("mama mia");
    user.setLastName("mama mama");
    ObjectMapper mapper = new ObjectMapper();

    String json = mapper.writeValueAsString(user);
    System.out.println(" \n \n JSON : " + json);
    /*MvcResult result = mockMvc
        .perform(post("/saveUser").content(json).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andDo(print()).andReturn();*/

    MvcResult result = mockMvc
        .perform(post("/saveUser").param("firstName", "ABC")
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andReturn();
         
      

    String json1 = result.getResponse().getContentAsString();
    User user1 = mapper.readValue(json1, User.class);


    System.out.println("\n\n\n --- MOCKMVC json1 : " + json1);
    System.out.println("\n\n\n --- MOCKMVC User1: " + user1);

  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
