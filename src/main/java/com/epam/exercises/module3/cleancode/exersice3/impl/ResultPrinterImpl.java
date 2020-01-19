package com.epam.exercises.module3.cleancode.exersice3.impl;

import com.epam.exercises.module3.cleancode.exersice3.ResultPrinter;

import java.util.ArrayList;

public class ResultPrinterImpl implements ResultPrinter {
  @Override
  public void printSolution(ArrayList<char[][]> solutions) {
    System.out.println(solutions.size());
    for (int i = 0; i < solutions.size(); i++) {
      System.out.println("\nSolution " + (i + 1));

      char[][] board = solutions.get(i);

      for (char[] chars : board) {
        for (char aChar : chars) {
          System.out.print(aChar);
        }
        System.out.println();
      }
    }
  }
}

