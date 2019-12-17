package com.epam.exercises.module1.calculator_exercise.exception;

import java.io.IOException;

public class InvalidInputException extends IOException {

   public InvalidInputException(String message) {
      super(message);
   }
}
