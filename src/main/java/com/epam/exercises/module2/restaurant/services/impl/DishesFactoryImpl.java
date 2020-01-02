package com.epam.exercises.module2.restaurant.services.impl;

import com.epam.exercises.module2.restaurant.enums.OrderComponents;
import com.epam.exercises.module2.restaurant.exception.IllegalDishesTypeException;
import com.epam.exercises.module2.restaurant.objects.Chips;
import com.epam.exercises.module2.restaurant.objects.Dish;
import com.epam.exercises.module2.restaurant.objects.HotDog;
import com.epam.exercises.module2.restaurant.services.AbstractFactory;

public class DishesFactoryImpl implements AbstractFactory<Dish> {

   @Override
   public Dish create(String dishesType) {
      if (OrderComponents.HOT_DOG.getValue().equals(dishesType)) {
         return new HotDog();
      } else if (OrderComponents.CHIPS.getValue().equals(dishesType)) {
         return new Chips();
      } else {
         throw new IllegalDishesTypeException(
             "There isn't such dish in our restaurant, please choose another dish.");
      }
   }
}
