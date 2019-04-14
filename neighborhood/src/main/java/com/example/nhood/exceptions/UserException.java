package com.example.nhood.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@SuppressWarnings("serial")
public class UserException extends ResponseStatusException{

  public UserException(HttpStatus status, String reason) {
    super(status, reason);
  }

  public static void forUserDataAccessException(String reason) {
    throw new UserException (HttpStatus.INTERNAL_SERVER_ERROR, reason);
}

}
