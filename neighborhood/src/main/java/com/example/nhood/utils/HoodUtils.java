package com.example.nhood.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HoodUtils {
  
  public String fromInt(Integer id) {
    return ( id == null ? null : Integer.toString(id) );
  }
  
  

}
