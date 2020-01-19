package com.epam.exercises.module3.cleancode.exersice1.exceptions;

public class FileNotFoundException extends RuntimeException {
  public FileNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
