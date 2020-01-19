package com.epam.exercises.module3.cleancode.exersice1.domain;

public class Coordinate {
  private static int x;
  private static int y;

  public Coordinate(int x, int y) {
    Coordinate.x = x;
    Coordinate.y = y;
  }

  public int getxCoordinate() {
    return x;
  }

  public int getY() {
    return y;
  }

}
