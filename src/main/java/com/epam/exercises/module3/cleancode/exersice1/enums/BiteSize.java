package com.epam.exercises.module3.cleancode.exersice1.enums;

public enum BiteSize {
  LAST_BYTE(0xFF), BYTE(8), TWO_BYTES(16);

  private int value;

  BiteSize(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
