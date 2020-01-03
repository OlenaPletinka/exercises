package com.epam.exercises.module2.sportsbetting.exceptions;

public class InvalidBetInputException extends RuntimeException {

   public InvalidBetInputException(String message) {
      super(message);
   }
}
