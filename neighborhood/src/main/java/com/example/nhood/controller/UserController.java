package com.example.nhood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.nhood.domain.User;
import com.example.nhood.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @ApiOperation(value = "Add a new User")
  @RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = "application/json")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully saved"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public User saveOffer(User user) {
    return userService.saveUser(user);
  }
 
  @ApiOperation(value = "Retrieve A user by email")
  @RequestMapping(value = "/getUser/{email} ", method = RequestMethod.GET)
  public User getUser(@ApiParam(value="user email" , name="email" ) @RequestParam String email) {
  
    return  userService.getUserByEmail(email);
  }

  
  @ApiOperation(value = "Retrieve A user by email in Path")
  @RequestMapping(value = "/getUser/{email}", method = RequestMethod.GET)
  public User getUserbyEmail(@ApiParam(value="user email" , name="email" ) @PathVariable String email) {
    System.out.println("\n\n \n ---" + email);
    return  userService.getUserByEmail(email);
  }

  
}
