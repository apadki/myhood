package com.example.nhood.offers;

import static org.junit.Assert.assertEquals;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.nhood.domain.User;
import com.example.nhood.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestWithH2 {
  @Autowired
  private JdbcTemplate jdbc;
  
  @Autowired 
  UserService userService;
  
//  private static final String CREATE_TABLE = "dbScripts/before/user.sql";
 // private static final String DROP_TABLE = "dbScripts/after/dropUser.sql";

  /*@Before 
  public void before() throws ScriptException, SQLException {
    Connection conn = jdbc.getDataSource().getConnection();
    ClassPathResource cpr = new ClassPathResource(CREATE_TABLE);
    ScriptUtils.executeSqlScript(conn,cpr);
  }
  
  @After
  public void after() throws SQLException {
    Connection conn = jdbc.getDataSource().getConnection();
    ClassPathResource cpr = new ClassPathResource(DROP_TABLE);
    ScriptUtils.executeSqlScript(conn,cpr);
  }*/
  
  
  @Test
  public void createUserRecord() throws Exception {
    
    User user = new User();
    user.setFirstName("FIRST11");
    user.setLastName("LAST");
    user.setEmail("FIRST@LAST.com");
    userService.saveUser(user);
    User user1 = userService.getUserByEmail("FIRST@LAST.com");
     assertEquals(user.getFirstName(), user1.getFirstName());
    
    
  }

  @Test
  public void retrieveUserByEmail() {
    User user1 = userService.getUserByEmail("anuradha@sahar.com");
    assertEquals(user1.getEmail(), "anuradha@sahar.com");
    
    
  }
}
