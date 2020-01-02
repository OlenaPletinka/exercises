package com.epam.exercises.module2.restaurant.objects;

import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {

   private String name;
   private BigDecimal happinessLevel;
   private Dish dish;

   public Client(String name) {

      this.name = name;
      happinessLevel = BigDecimal.ZERO;
   }

   @Override
   public void update(Observable o, Object dish) {
      this.setDish((Dish) dish);

   }

   private void setDish(Dish dish) {
      this.dish = dish;
   }

   public String getName() {
      return name;
   }

   public BigDecimal getHappinessLevel() {
      return happinessLevel;
   }

   public void setHappinessLevel(BigDecimal happinessLevel) {
      this.happinessLevel = happinessLevel;
   }
}
