package com.epam.exercises.module1.calculator_exercise.utils;

import com.epam.exercises.module1.calculator_exercise.exception.FormatNumberException;
import com.epam.exercises.module1.calculator_exercise.exception.InvalidInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InputHelper {

   private static final String REGEX_FOR_CALCULATOR = "^[\\d\\+\\/\\*\\.\\- \\(\\)]*$";

   public static String getExpression() {

      System.out.println("Enter an expression: ");

      String line = null;

      try (BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(System.in))) {

         line = bufferedReader.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }

      validate(line);

      System.out.println(line);

      return line;
   }

   public static String[] getOperations(String line){
      String[] operations = line.split("[0-9]+");
      System.out.println(Arrays.toString(operations));

      return operations;
   }

   public static int [] getNumbers(String line){
      int[] numbers = convert(getStringsOfNumber(line));
      System.out.println(Arrays.toString(numbers));

      return numbers;
   }

   private static int[] convert(String[] numbers) {
      try {
         return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
      } catch (NumberFormatException e){
         throw new FormatNumberException("Please enter correct number format!", e);
      }
   }

   private  static String[] getStringsOfNumber(String line) {
      String[] numbers = line.split("[" + Pattern.quote("+-*/") + "]");
      System.out.println(Arrays.toString(numbers));
      return numbers;
   }

   private static void validate(String line) throws InvalidInputException {
      if (!line.matches(REGEX_FOR_CALCULATOR)) {
         throw new InvalidInputException("Please, enter valid expression!");
      }
   }
}
