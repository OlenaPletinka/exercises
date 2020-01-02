package com.epam.exercises.module1.calculator_exercise.exception;

public class FormatNumberException extends RuntimeException {

   public FormatNumberException(String message, Throwable cause) {
      super(message, cause);
   }
}
