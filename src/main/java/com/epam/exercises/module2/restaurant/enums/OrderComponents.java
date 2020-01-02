package com.epam.exercises.module2.restaurant.enums;

public enum OrderComponents {
   HOT_DOG("hot dog"), CHIPS("chips"), KETCHUP("ketchup"),
   MUSTARD("mustard");

   private String value;

   OrderComponents(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }
}
