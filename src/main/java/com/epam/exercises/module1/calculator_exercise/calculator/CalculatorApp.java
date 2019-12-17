package com.epam.exercises.module1.calculator_exercise.calculator;

import static com.epam.exercises.module1.calculator_exercise.calculator.utils.InputHelper.getExpression;

import com.epam.exercises.module1.calculator_exercise.calculator.exception.InvalidInputException;

public class CalculatorApp {

   public static void main(String[] args) throws InvalidInputException {

      Calculator calculator = new Calculator();

      System.out.println(calculator.calculate(getExpression()));
   }
}