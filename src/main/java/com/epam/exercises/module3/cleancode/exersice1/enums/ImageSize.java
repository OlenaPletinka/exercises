package com.epam.exercises.module3.cleancode.exersice1.enums;

public enum ImageSize {
  MIN(255 * 3), MAX(0);
  private int size;

  ImageSize(int size) {
    this.size = size;
  }

  public int getSize() {
    return size;
  }
}
