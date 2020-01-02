package com.epam.exercises.module2.restaurant.objects;

import com.epam.exercises.module2.restaurant.enums.OrderComponents;
import com.epam.exercises.module2.restaurant.services.MealDecorator;

public class Ketchup extends MealDecorator {

   private static final String type = OrderComponents.KETCHUP.getValue();

   public Ketchup(Dish dish) {
      super(dish);
   }

   @Override
   public String getType() {
      return type;
   }

   @Override
   public String decorate() {
      return super.decorate() + " with " + type;
   }
}
