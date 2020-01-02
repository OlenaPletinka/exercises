package com.epam.exercises.module2.restaurant.services.impl;

import com.epam.exercises.module2.restaurant.enums.OrderComponents;
import com.epam.exercises.module2.restaurant.objects.Dish;
import com.epam.exercises.module2.restaurant.objects.Order;
import com.epam.exercises.module2.restaurant.services.HappinessLevelCalculator;
import java.math.BigDecimal;

public class HappinessLevelCalculatorImpl implements HappinessLevelCalculator {

   @Override
   public BigDecimal calculateHappinessLevel(Order order) {
      BigDecimal currentHappinessLevel = order.getClient().getHappinessLevel();
      Dish dish = order.getDish();
      String ingredients = dish.decorate();
      currentHappinessLevel = calculateHappinesLevelForDish(currentHappinessLevel, ingredients);
      currentHappinessLevel = calculateHappinesLevelForExtras(order, currentHappinessLevel,
          ingredients);
      order.getClient().setHappinessLevel(currentHappinessLevel);

      return currentHappinessLevel;
   }

   private static BigDecimal calculateHappinesLevelForExtras(Order order, BigDecimal currenthappinessLevel,
       String ingredients) {
      if (ingredients.contains(OrderComponents.KETCHUP.getValue())) {
         currenthappinessLevel = calculateHappinesLevelForDish(currenthappinessLevel, ingredients);
      }
      if (ingredients.contains(OrderComponents.MUSTARD.getValue())) {
         currenthappinessLevel = order.getClient().getHappinessLevel().add(BigDecimal.ONE);
      }
      return currenthappinessLevel;
   }

   private static BigDecimal calculateHappinesLevelForDish(BigDecimal currenthappinessLevel,
       String ingredients) {
      if (ingredients.contains(OrderComponents.HOT_DOG.getValue())) {
         currenthappinessLevel = currenthappinessLevel.add(BigDecimal.valueOf(2.0));
      } else if (ingredients.contains(OrderComponents.CHIPS.getValue())) {
         if (currenthappinessLevel.equals(BigDecimal.ZERO)){
            currenthappinessLevel = BigDecimal.valueOf(0.05);
         }else {
         currenthappinessLevel = currenthappinessLevel.multiply(BigDecimal.valueOf(1.05));
         }
      }
      return currenthappinessLevel;
   }

}
