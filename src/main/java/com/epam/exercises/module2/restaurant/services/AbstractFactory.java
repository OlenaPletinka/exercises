package com.epam.exercises.module2.restaurant.services;

public interface AbstractFactory<T> {

   T create(String dishesType);
}
