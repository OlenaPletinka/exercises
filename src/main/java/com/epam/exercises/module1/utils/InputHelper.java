package com.epam.exercises.module1.utils;

import com.epam.exercises.module1.exception.InvalidInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper {

   private static final String REGEX_FOR_CALCULATOR = "^[\\d\\+\\/\\*\\.\\- \\(\\)]*$";

   public static String getExpression() throws InvalidInputException {

      System.out.println("Enter an expression: ");

      String line = null;

      try (BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(System.in))) { //instead of

         line = bufferedReader.readLine();

      } catch (IOException e) {
         e.printStackTrace();
      }

      validate(line);

      System.out.println(line);

      return line;
   }

   private static void validate(String line) throws InvalidInputException {
      if (!line.matches(REGEX_FOR_CALCULATOR)) {
         throw new InvalidInputException("Please, enter valid expression!");
      }
   }
}
