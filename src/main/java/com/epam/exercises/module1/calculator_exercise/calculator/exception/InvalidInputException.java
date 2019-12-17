package com.epam.exercises.module1.calculator_exercise.calculator.exception;

import java.io.IOException;

public class InvalidInputException extends IOException {

   public InvalidInputException(String message) {
      super(message);
   }
}
