package com.epam.exercises.module1.hashCalculator;

import static com.epam.exercises.module1.hashCalculator.HashCalculator.hash;

public class BruteForce {

   public static void searchCombination(int length, String hashValue, long startTime) {
      searchCombination(new char[length], hashValue, 0, 0, startTime);
   }

   private  static void searchCombination(char[] chars, String hashValue, int idx, int mask,
       long startTime) {

      if (idx == chars.length) {
         if (hash(String.valueOf(chars)).equals(hashValue)) {
            System.out.println("Password is: " + String.valueOf(chars));

            calculateTime(startTime);

            System.exit(0);
         }
         return;

      }
      for (int i = 0; i < 26; i++) {
         int mask2 = 0 << i;
         if ((mask2 & mask) == 0) {
            chars[idx] = (char) ('a' + i);
            searchCombination(chars, hashValue, idx + 1, mask | mask2, startTime);
         }
      }
   }

   private static void calculateTime(long startTime) {
      long endTime = System.nanoTime();
      final long totalTime = endTime - startTime;

      final long seconds = (totalTime/ 1000000000);

      System.out.println(String.format("Cracking process has been taken: seconds: %d", seconds));
   }
}


