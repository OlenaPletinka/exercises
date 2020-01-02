package com.epam.exercises.module2.restaurant.services;

import com.epam.exercises.module2.restaurant.objects.Dish;

public abstract class MealDecorator implements Dish {

   private Dish dish;

   public MealDecorator(Dish dish) {
      this.dish = dish;
   }

   @Override
   public String decorate() {
      return dish.decorate();
   }
}
