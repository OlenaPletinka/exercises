package com.epam.exercises.module1.calculator_exercise;

import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getExpression;
import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getNumbers;
import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getOperations;

import com.epam.exercises.module1.calculator_exercise.calculator.Calculator;
import com.epam.exercises.module1.calculator_exercise.exception.InvalidInputException;

public class CalculatorApp {

   public static void main(String[] args) throws InvalidInputException {

//      runCalculator();

      runCalculator2();
   }

   private static void runCalculator() {
      Calculator calculator = new Calculator();

      System.out.println(calculator.calculate(getExpression()));
   }

   private static void runCalculator2() {
      com.epam.exercises.module1.calculator_exercise.calculator2.Calculator calculator2 = new com.epam.exercises.module1.calculator_exercise.calculator2.Calculator();
      String expression = getExpression();

      System.out.println(
          "Result is: " + calculator2.calculate(getNumbers(expression), getOperations(expression)));
   }
}
