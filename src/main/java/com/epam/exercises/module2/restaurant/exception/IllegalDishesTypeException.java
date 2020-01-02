package com.epam.exercises.module2.restaurant.exception;

public class IllegalDishesTypeException extends RuntimeException{

   public IllegalDishesTypeException(String message) {
      super(message);
   }
}
