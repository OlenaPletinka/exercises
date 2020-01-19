package com.epam.exercises.module3.cleancode.exersice3.impl;

import com.epam.exercises.module3.cleancode.exersice3.PrepareData;

import java.util.Arrays;

public class PrepareDataImpl implements PrepareData {
  @Override
  public char[][] getChars() {
    char[][] result = new char[8][8];
    for (int r1 = 0; r1 < 8; r1++) {
      Arrays.fill(result[r1], '.');
    }
    return result;
  }
}
