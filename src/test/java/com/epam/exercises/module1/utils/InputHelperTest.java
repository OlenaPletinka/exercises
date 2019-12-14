package com.epam.exercises.module1.utils;

import com.epam.exercises.module1.exception.InvalidInputException;
import java.io.ByteArrayInputStream;
import org.junit.Test;

public class InputHelperTest {

   private String correctInput = "1+2";
   private String incorrectInput = "wrong";

   @Test
   public void getExpression() throws Exception {
      provideInput(correctInput);
      InputHelper.getExpression();
   }

   @Test(expected = InvalidInputException.class)
   public void getWrongExpression() throws Exception {
      provideInput(incorrectInput);
      InputHelper.getExpression();
   }

   private void provideInput(String data) {
      ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
      System.setIn(testIn);
   }
}

