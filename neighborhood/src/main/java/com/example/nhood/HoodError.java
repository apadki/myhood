package com.example.nhood;

import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class HoodError {
  private HttpStatus status;
  private String message;
  private List<String> errors;

  public HoodError(HttpStatus status, String message, List<String> errors) {
      super();
      this.status = status;
      this.message = message;
      this.errors = errors;
  }

  public HoodError(HttpStatus status, String message, String error) {
      super();
      this.status = status;
      this.message = message;
      errors = Arrays.asList(error);
  }

 
}
