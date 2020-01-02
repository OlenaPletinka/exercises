package com.epam.exercises.module1.calculator_exercise.exception;

public class InvalidInputException extends RuntimeException {

   public InvalidInputException(String message) {
      super(message);
   }
}
