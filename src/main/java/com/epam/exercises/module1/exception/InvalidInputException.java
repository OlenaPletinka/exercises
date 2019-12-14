package com.epam.exercises.module1.exception;

import java.io.IOException;

public class InvalidInputException extends IOException {

   public InvalidInputException(String message) {
      super(message);
   }
}
