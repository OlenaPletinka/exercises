package com.epam.exercises.module2.restaurant;

import com.epam.exercises.module2.restaurant.enums.OrderComponents;
import com.epam.exercises.module2.restaurant.objects.Client;
import com.epam.exercises.module2.restaurant.objects.Dish;
import com.epam.exercises.module2.restaurant.objects.Ketchup;
import com.epam.exercises.module2.restaurant.objects.Mustard;
import com.epam.exercises.module2.restaurant.objects.Order;
import com.epam.exercises.module2.restaurant.services.impl.DishesFactoryImpl;
import com.epam.exercises.module2.restaurant.services.impl.RobotImpl;

public class Restaurant {

   private static RobotImpl robotImpl = new RobotImpl();
   private static DishesFactoryImpl dishesFactoryImpl = new DishesFactoryImpl();

   public static void main(String[] args) {
      Dish dishFirst = new Ketchup(dishesFactoryImpl.create(OrderComponents.HOT_DOG.getValue()));
      Order tomsOrder = new Order(new Client("Tom"), dishFirst);
      System.out.println("First order is: " + dishFirst.decorate());

      Dish dishSecond = new Mustard(
          new Ketchup(dishesFactoryImpl.create(OrderComponents.CHIPS.getValue())));
      Order lizasOrder = new Order(new Client("Liza"), dishSecond);
      System.out.println("Second order is: " + dishSecond.decorate());

      robotImpl.startProcessing();
   }

}
