package com.epam.exercises.module2.sportsbetting.exceptions;

public class InvalidBalanceInputException extends RuntimeException {

   public InvalidBalanceInputException(String message) {
      super(message);
   }
}
