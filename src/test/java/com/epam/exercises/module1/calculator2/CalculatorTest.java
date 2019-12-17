package com.epam.exercises.module1.calculator2;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
   private Calculator calculator = new Calculator();

   @Test
   public void calculateSum() {
      //given
      int[] numbers = prepareNumbers();
      String[] operations = prepareSumOperator();

      //when
      int actualResult = calculator.calculate(numbers, operations);

      //then
      Assert.assertEquals(12, actualResult);
   }

   @Test
   public void calculateSubctraction() {
      //given
      int[] numbers = prepareNumbers();
      String[] operations = prepareSubstactionOperator();

      //when
      int actualResult = calculator.calculate(numbers, operations);

      //then
      Assert.assertEquals(8, actualResult);
   }

   @Test
   public void calculateMultiplication() {
      //given
      int[] numbers = prepareNumbers();
      String[] operations = prepareMultiplicationOperator();

      //when
      int actualResult = calculator.calculate(numbers, operations);

      //then
      Assert.assertEquals(20, actualResult);
   }

   @Test
   public void calculateDivision() {
      //given
      int[] numbers = prepareNumbers();
      String[] operations = prepareDivisionOperator();

      //when
      int actualResult = calculator.calculate(numbers, operations);

      //then
      Assert.assertEquals(5, actualResult);
   }

   @Test
   public void calculateComplexExample() {
      //given
      int[] numbers = prepareMultiNumbers();
      String[] operations = prepareDComplexOperator();

      //when
      int actualResult = calculator.calculate(numbers, operations);

      //then
      Assert.assertEquals(18, actualResult);
   }

   private int[] prepareMultiNumbers() {
      return new int[]{10, 2, 4};
   }

   private String[] prepareDComplexOperator() {
      return new String[]{"", "+","*"};
   }

   private String[] prepareDivisionOperator() {
      return new String[]{"", "/"};
   }

   private String[] prepareMultiplicationOperator() {
      return new String[]{"", "*"};
   }

   private String[] prepareSubstactionOperator() {
      return new String[]{"", "-"};
   }

   private String[] prepareSumOperator() {
      return  new String[]{ "", "+"};
   }

   private int[] prepareNumbers() {
      return new int[]{10, 2};
   }
}