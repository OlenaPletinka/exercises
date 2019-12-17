package com.epam.exercises.module1.calculator_exercise.enums;

public enum Operations {
   MULTIPLICATION("*"), DIVISION("/"), SUM("+"), SUBSTRACTION("-");

   private String operation;

   Operations(String operation) {
      this.operation = operation;
   }

   public String operation(){
      return operation;
   }
}
