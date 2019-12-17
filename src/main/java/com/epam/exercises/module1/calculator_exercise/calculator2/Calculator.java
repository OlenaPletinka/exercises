package com.epam.exercises.module1.calculator_exercise.calculator2;

import com.epam.exercises.module1.calculator_exercise.utils.MathHelper;

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
         if (MathHelper.isSum(operations[index]) || MathHelper.isSubstraction(operations[index])) {
            numbers[index - 1] = MathHelper.isSum(operations[index]) ? MathHelper
                .sum(numbers[index - 1], numbers[index])
                : MathHelper.substraction(numbers[index - 1], numbers[index]);
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
         if (MathHelper.isMultiplication(operations[index]) || MathHelper.isDivision(operations[index])) {
            numbers[index - 1] =
                MathHelper.isMultiplication(operations[index]) ? MathHelper
                    .multiplication(numbers[index - 1],
                    numbers[index]) : MathHelper.division(numbers[index - 1], numbers[index]);
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


