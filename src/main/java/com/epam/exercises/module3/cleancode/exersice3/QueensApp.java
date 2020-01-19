package com.epam.exercises.module3.cleancode.exersice3;

import com.epam.exercises.module3.cleancode.exersice3.impl.PrepareDataImpl;
import com.epam.exercises.module3.cleancode.exersice3.impl.ResultPrinterImpl;

import java.util.ArrayList;


public class QueensApp {
  private static PrepareDataImpl prepareData = new PrepareDataImpl();
  private static ResultPrinterImpl resultPrinter = new ResultPrinterImpl();

  /**
   * Main method of the application.
   * @param args arguments of the method.
   */
  public static void main(String[] args) {
    EightQueens eightQueens = new EightQueens();
    ArrayList<char[][]> solutions = new ArrayList<>();

    char[][] result = prepareData.getChars();

    eightQueens.solveAllNQueens(result, 0, solutions);

    resultPrinter.printSolution(solutions);
  }
}
