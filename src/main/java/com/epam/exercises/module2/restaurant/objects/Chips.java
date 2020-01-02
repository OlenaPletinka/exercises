package com.epam.exercises.module2.restaurant.objects;

import com.epam.exercises.module2.restaurant.enums.OrderComponents;

public class Chips implements Dish {
   private static final String  type = OrderComponents.CHIPS.getValue();

   @Override
   public String getType() {
      return type;
   }

   @Override
   public String decorate() {
      return type;
   }
}
