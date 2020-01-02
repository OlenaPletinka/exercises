package com.epam.exercises.module2.restaurant.services.impl;


import com.epam.exercises.module2.restaurant.objects.Order;
import com.epam.exercises.module2.restaurant.objects.OrderPool;
import com.epam.exercises.module2.restaurant.services.HappinessLevelCalculator;
import com.epam.exercises.module2.restaurant.services.Robot;
import java.math.BigDecimal;

public class RobotImpl implements Robot {

   private HappinessLevelCalculator calculateHappinessLevel = new HappinessLevelCalculatorImpl();

   @Override
   public void startProcessing() {
      while (!OrderPool.orders.isEmpty()) {
         Order order = OrderPool.orders.element();
         order.setMeal(order.getDish());
         System.out
             .println("Order for the client " + order.getClient().getName() + " was prepared.");

         BigDecimal happinessLevel = calculateHappinessLevel.calculateHappinessLevel(order)
             .setScale(2, BigDecimal.ROUND_HALF_DOWN);
         System.out.println("Current " + order.getClient().getName() + "'s level of happiness is - "
             + happinessLevel);
         order = OrderPool.orders.poll();
      }

      System.out.println("All orders was prepared!");
   }

}
