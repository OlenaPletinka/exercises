package com.epam.exercises.module1.hashCalculator;

public class HashCalculatorApp {

   public static void main(String[] args) {
      String hashValue = "4fd0101ea3d0f5abbe296ef97f47afec";
      ProcessExecutor processExecutor = new ProcessExecutor();
      long startTime = System.nanoTime();
      processExecutor.execute(hashValue, startTime);
   }
}

