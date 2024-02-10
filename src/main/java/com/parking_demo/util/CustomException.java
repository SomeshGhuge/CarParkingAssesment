package com.parking_demo.util;

public class CustomException extends RuntimeException {
    private String message;
   public CustomException(String message){
       super(message);
   }
}
