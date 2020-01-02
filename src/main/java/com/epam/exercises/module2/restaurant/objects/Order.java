package com.epam.exercises.module2.restaurant.objects;

import java.util.Observable;

public class Order extends Observable {
   private Client client;
   private Dish dish;

   public Order(Client client, Dish dish) {
      this.client = client;
      this.dish = dish;
      OrderPool.orders.add(this);
      addObserver(client);
   }

   public void setMeal(Dish dish) {
      this.dish = dish;
      setChanged();
      notifyObservers(dish);
   }

   public Client getClient() {
      return client;
   }

   public Dish getDish() {
      return dish;
   }
}
