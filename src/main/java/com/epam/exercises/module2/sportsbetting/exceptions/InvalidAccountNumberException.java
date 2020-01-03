package com.epam.exercises.module2.sportsbetting.exceptions;

public class InvalidAccountNumberException extends RuntimeException {

   public InvalidAccountNumberException(String message) {
      super(message);
   }
}

