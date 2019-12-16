//package com.epam.exercises.module1.calculator2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.regex.Pattern;
//
//public class Calculator {
//   private static final String MULTIPLICATION = "*";
//   private static final String DIVISION = "/";
//   private static final String SUM = "+";
//   private static final String SUBSTRACTION = "-";
//
//   private static int calculate(String[] operations, int[] numbers) {
//
//         while (index < length) {
//            if ("*".equals(operations[index])) { // NEM!!! "*" == operations[i]
//               numbers[index - 1] = numbers[index - 1] * numbers[index];
//               for (int j = index; j < length - 1; j++) {
//                  numbers[j] = numbers[j + 1];
//                  operations[j] = operations[j + 1];
//               }
//               length--;
//            } else if ("/".equals(operations[index])) { // NEM!!! "/" == operations[i]
//               numbers[index - 1] = numbers[index - 1] / numbers[index];
//               for (int j = index; j < length - 1; j++) {
//                  numbers[j] = numbers[j + 1];
//                  operations[j] = operations[j + 1];
//               }
//               length--;
//            } else {
//               index++;
//            }
//         }
//         index = 1;
//         while (index < length) {
//            if ("+".equals(operations[index])) { // NEM!!! "+" == operations[i]
//               numbers[index - 1] = numbers[index - 1] + numbers[index];
//               for (int j = index; j < length - 1; j++) {
//                  numbers[j] = numbers[j + 1];
//                  operations[j] = operations[j + 1];
//               }
//               length--;
//            } else if ("-".equals(operations[index])) { // NEM!!! "-" == operations[i]
//               numbers[index - 1] = numbers[index - 1] - numbers[index];
//               for (int j = index; j < length - 1; j++) {
//                  numbers[j] = numbers[j + 1];
//                  operations[j] = operations[j + 1];
//               }
//               length--;
//            } else {
//               index++;
//            }
//         }
//         return numbers[0];
//      }
//
//
//   public double calculate(int[] numbers, String[] operations) {
//      int length = operations.length;
//      int index = 1;
//      implementPriorityOperations(length, index, numbers, operations);
//
//   }
//
//   private double implementPriorityOperations(int length, int index, int[] numbers,
//       String[] operations) {
//      while (index < length) {
//         if ("*".equals(operations[index])) { // NEM!!! "*" == operations[i]
//            numbers[index - 1] = numbers[index - 1] * numbers[index];
//            for (int j = index; j < length - 1; j++) {
//               numbers[j] = numbers[j + 1];
//               operations[j] = operations[j + 1];
//            }
//            length--;
//         } else if ("/".equals(operations[index])) { // NEM!!! "/" == operations[i]
//            numbers[index - 1] = numbers[index - 1] / numbers[index];
//            for (int j = index; j < length - 1; j++) {
//               numbers[j] = numbers[j + 1];
//               operations[j] = operations[j + 1];
//            }
//            length--;
//         } else {
//            index++;
//         }
//      }
//      return 0;
//   }
//}
//
//
