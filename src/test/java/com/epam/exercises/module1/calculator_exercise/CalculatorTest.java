package com.epam.exercises.module1.calculator_exercise;

import static org.junit.Assert.assertEquals;

import com.epam.exercises.module1.calculator_exercise.calculator.Calculator;
import org.junit.Test;

public class CalculatorTest {

   private Calculator calculator = new Calculator();

   @Test
   public void calculateAddValues() {
      Object actualResult = calculator.calculate("2 + 3");

      assertEquals(5, actualResult);
   }

   @Test
   public void calculateSubstractValues() {
      Object actualResult = calculator.calculate("2 - 3");

      assertEquals((-1), actualResult);
   }

   @Test
   public void calculateMultiplyValues() {
      Object actualResult = calculator.calculate("2 * 3");

      assertEquals(6, actualResult);
   }

   @Test
   public void calculateDivideValues() {
      Object actualResult = calculator.calculate("6 / 3");

      assertEquals(2, actualResult);
   }

   @Test
   public void calculateComplexOperations() {
      Object actualResult = calculator.calculate("5 - 6 / 3");

      assertEquals(3, actualResult);
   }
}