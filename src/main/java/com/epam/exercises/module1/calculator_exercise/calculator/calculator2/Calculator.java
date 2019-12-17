package com.epam.exercises.module1.calculator_exercise.calculator.calculator2;

import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.division;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.isDivision;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.isMultiplication;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.isSubstraction;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.isSum;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.multiplication;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.substraction;
import static com.epam.exercises.module1.calculator_exercise.calculator.utils.MathHelper.sum;

public class Calculator {

   public int calculate(int[] numbers, String[] operations) {
      int length = operations.length;
      implementPriorityOperations(length, numbers, operations);
      implementNonPriorityOperations(length, numbers, operations);
      return numbers[0];

   }

   private void implementNonPriorityOperations(int length, int[] numbers, String[] operations) {
      int index = 1;
      while (index < length) {
         if (isSum(operations[index]) || isSubstraction(operations[index])) {
            numbers[index - 1] = isSum(operations[index]) ? sum(numbers[index - 1], numbers[index])
                : substraction(numbers[index - 1], numbers[index]);
            getNext(length, numbers, operations, index);
            length--;
         } else {
            index++;
         }
      }
   }

   private void implementPriorityOperations(int length, int[] numbers, String[] operations) {
      int index = 1;
      while (index < length) {
         if (isMultiplication(operations[index]) || isDivision(operations[index])) {
            numbers[index - 1] =
                isMultiplication(operations[index]) ? multiplication(numbers[index - 1],
                    numbers[index]) : division(numbers[index - 1], numbers[index]);
            getNext(length, numbers, operations, index);
            length--;
         } else {
            index++;
         }
      }
   }

   private void getNext(int length, int[] numbers, String[] operations, int index) {
      for (int j = index; j < length - 1; j++) {
         numbers[j] = numbers[j + 1];
         operations[j] = operations[j + 1];
      }
   }
}


