package com.epam.exercises.module2.sportsbetting.exceptions;

public class InvalidNameInputException extends RuntimeException {

   public InvalidNameInputException(String message) {
      super(message);
   }
}
