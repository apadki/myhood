package com.example.nhood.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.nhood.domain.User;
import com.example.nhood.exceptions.UserException;
import com.example.nhood.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  /*@ApiOperation(value = "Add a new User")
  @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully saved"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
  @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public  User  saveUser(@Valid  User user, BindingResult bindingResult) throws BindException {
    
    if (bindingResult.hasErrors()) {
      System.out.println("\n\n\n------------   User not valid: "+bindingResult.getAllErrors());
      throw new BindException(bindingResult);  
    }
    
   return userService.saveUser(user);
   
  }*/
 
  @RequestMapping(value = "/saveUser1", method = RequestMethod.POST)
 public  User  saveUser1(@Valid  User user) throws UserException {
    
    /*if (bindingResult.hasErrors()) {
      System.out.println("\n\n\n------------   User not valid: "+bindingResult.getAllErrors());
      throw new BindException(bindingResult);  
    }*/
    
   return userService.saveUser(user);
   
  }
  
  @ApiOperation(value = "Retrieve A user by email in Path")
  @RequestMapping(value = "/getUser/{email}", method = RequestMethod.GET)
  public User getUserbyEmail(@ApiParam(value="user email" , name="email" ) @PathVariable String email) {
    
    return  userService.getUserByEmail(email);
  }
  
 
  @ApiOperation(value = "Retrieve A user by email in Path")
  @RequestMapping(value = "/getUserId/{id}", method = RequestMethod.GET)
  public User getUserbyId(@ApiParam(value="user id" , name="id" ) @PathVariable String id) {
    
    return  userService.getUserById(id);
  }
  
  
  
}
