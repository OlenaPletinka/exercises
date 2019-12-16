package com.epam.exercises.module1.hashCalculator;

import static com.epam.exercises.module1.hashCalculator.BruteForce.searchCombination;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProcessExecutor {
   private static final int QUEUE_CAPACITY = 4;
   private static int RANGE = 5;
   private int counter = RANGE;

   public void execute(String hashValue, long startTime) {

      final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
      ExecutorService executorService = new ThreadPoolExecutor(4, 10, 0L, TimeUnit.MILLISECONDS,
          queue);
      executorService.submit(submitTask(hashValue, startTime, 1, counter));

      while (queue.size() < QUEUE_CAPACITY) {
         int finish = counter + RANGE;
         executorService.submit(submitTask(hashValue, startTime, counter + 1, finish));
         counter = finish;
      }
   }

   private Runnable submitTask(String hashValue, long startTime, int start, int finish) {
      return () -> checkRange(hashValue, startTime, start, finish);
   }

   private void checkRange(String hashValue, long startTime, int i2, int i3) {
      for (int i = i2; i <= i3; i++) {
         System.out.println("Thread name is " + Thread.currentThread().getName());
         searchCombination(i, hashValue, startTime);
      }
   }
}
