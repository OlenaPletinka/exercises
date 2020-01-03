package com.epam.exercises.module2.sportsbetting.exceptions;

public class InvalidCurrencyInputException extends RuntimeException {

   public InvalidCurrencyInputException(String message) {
      super(message);
   }
}
