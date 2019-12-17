package com.epam.exercises.module1.calculator_exercise.calculator2;

import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getExpression;
import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getNumbers;
import static com.epam.exercises.module1.calculator_exercise.utils.InputHelper.getOperations;

import com.epam.exercises.module1.calculator_exercise.exception.InvalidInputException;

public class CalculatorApp {

   public static void main(String[] args) throws InvalidInputException {

      Calculator calculator = new Calculator();
      String expression = getExpression();

      System.out.println(
          "Result is: " + calculator.calculate(getNumbers(expression), getOperations(expression)));
   }
}
