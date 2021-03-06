package com.epam.exercises.module1.calculator_exercise.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

   public Object calculate(String expression) {

      ScriptEngineManager manager = new ScriptEngineManager();
      ScriptEngine se = manager.getEngineByName("JavaScript");

      Object result = null;
      try {
         result = se.eval(expression);
      } catch (ScriptException e) {
         e.printStackTrace();
      }

      return result;
   }
}
