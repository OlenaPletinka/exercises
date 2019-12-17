package com.epam.exercises.module1.calculator_exercise.utils;

import static com.epam.exercises.module1.calculator_exercise.enums.Operations.DIVISION;
import static com.epam.exercises.module1.calculator_exercise.enums.Operations.MULTIPLICATION;
import static com.epam.exercises.module1.calculator_exercise.enums.Operations.SUBSTRACTION;
import static com.epam.exercises.module1.calculator_exercise.enums.Operations.SUM;

public class MathHelper {

   public static int multiplication(int first, int second) {
      return first * second;
   }

   public static int substraction(int first, int second) {
      return first - second;
   }

   public static int sum(int first, int second) {
      return first + second;
   }

   public static int division(int first, int second) {
      return first / second;
   }

   public static boolean isMultiplication(String operator) {
      return MULTIPLICATION.operation().equals(operator);
   }

   public static boolean isDivision(String operator) {
      return DIVISION.operation().equals(operator);
   }

   public static boolean isSum(String operator) {
      return SUM.operation().equals(operator);
   }

   public static boolean isSubstraction(String operator) {
      return SUBSTRACTION.operation().equals(operator);
   }
}
