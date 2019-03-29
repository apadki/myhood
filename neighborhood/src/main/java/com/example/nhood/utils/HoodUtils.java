package com.example.nhood.utils;

import org.springframework.stereotype.Service;

@Service
public class HoodUtils {
  
  public String fromInt(Integer id) {
    return ( id == null ? null : Integer.toString(id) );
  }

}
