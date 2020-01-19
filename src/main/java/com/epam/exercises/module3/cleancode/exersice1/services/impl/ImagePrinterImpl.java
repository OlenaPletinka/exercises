package com.epam.exercises.module3.cleancode.exersice1.services.impl;

import com.epam.exercises.module3.cleancode.exersice1.domain.Coordinate;
import com.epam.exercises.module3.cleancode.exersice1.domain.Image;
import com.epam.exercises.module3.cleancode.exersice1.services.ImagePrinter;

import static com.epam.exercises.module3.cleancode.exersice1.enums.ImageSize.MAX;
import static com.epam.exercises.module3.cleancode.exersice1.enums.ImageSize.MIN;

public class ImagePrinterImpl implements ImagePrinter {

  /**
   * method print image.
   * @param image image be printed.
   */
  @Override
  public void printImage(Image image) {
    char[] charsByDarkness = {'#', '@', 'X', 'L', 'I', ':', '.', ' '};
    int max = MAX.getSize();
    int min = MIN.getSize();
    int stepY = image.getHeight() / 60;
    int stepX = image.getWidth() / 200;
    for (int y = 0; y < image.getHeight(); y += stepY) {
      for (int x = 0; x < image.getWidth(); x += stepX) {
        int sum = 0;
        for (int avgy = 0; avgy < stepY; avgy++) {
          for (int avgx = 0; avgx < stepX; avgx++) {
            sum = sum + (image.getIntensity(new Coordinate(x, y)));
          }
        }
        sum = sum / stepY / stepX;
        if (max < sum) {
          max = sum;
        }
        if (min > sum) {
          min = sum;
        }
      }
    }
    for (int y = 0; y < image.getHeight() - stepY; y += stepY) {
      for (int x = 0; x < image.getWidth() - stepX; x += stepX) {
        int sum = getSum(image, stepY, stepX, y, x);

        System.out.print(charsByDarkness[(sum - min) * charsByDarkness.length / (max - min + 1)]);
      }
      System.out.println();
    }
  }

  private int getSum(Image image, int stepY, int stepX, int y, int x) {
    int sum = 0;
    for (int avgy = 0; avgy < stepY; avgy++) {
      for (int avgx = 0; avgx < stepX; avgx++) {
        sum = sum + (image.getIntensity(new Coordinate(x, y)));
      }
    }
    sum = sum / stepY / stepX;
    return sum;
  }
}
