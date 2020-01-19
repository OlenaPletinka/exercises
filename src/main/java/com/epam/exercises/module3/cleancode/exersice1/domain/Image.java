package com.epam.exercises.module3.cleancode.exersice1.domain;

import com.epam.exercises.module3.cleancode.exersice1.exceptions.XCoordinateOutOfRangeException;
import com.epam.exercises.module3.cleancode.exersice1.exceptions.YCoordinateOutOfRangeException;
import com.epam.exercises.module3.cleancode.exersice1.services.impl.ImageLoaderImpl;

import java.awt.image.BufferedImage;

import static com.epam.exercises.module3.cleancode.exersice1.enums.BiteSize.*;



public class Image {

  private BufferedImage image;

  private Image(String fileName) {
    ImageLoaderImpl imageLoader = new ImageLoaderImpl();
    this.image = imageLoader.loadImageFromFile(fileName);
  }

  public static Image createImage() {
    return new Image("pair_hiking.png");
  }

  public int getHeight() {
    return image.getHeight();
  }

  public int getWidth() {
    return image.getWidth();
  }

  public int getIntensity(Coordinate coordinate) {
    return getRed(coordinate) + getBlue(coordinate) + getGreen(coordinate);
  }

  private int getRed(Coordinate coordinate) {
    int rgbValue = getRgbValue(coordinate);
    return (rgbValue >> TWO_BYTES.getValue()) & LAST_BYTE.getValue();
  }

  private int getGreen(Coordinate coordinate) {
    int rgbValue = getRgbValue(coordinate);
    return (rgbValue >> BYTE.getValue()) & LAST_BYTE.getValue();
  }

  private int getBlue(Coordinate coordinate) {
    int rgbValue = getRgbValue(coordinate);
    return rgbValue & LAST_BYTE.getValue();
  }

  private int getRgbValue(Coordinate coordinate) {
    if (coordinate.getxCoordinate() < 0 || coordinate.getxCoordinate() > image.getWidth()) {
      throw new XCoordinateOutOfRangeException("Coordinate x out of range: 0.." + image.getWidth());
    } else if (coordinate.getY() < 0 || coordinate.getY() > image.getHeight()) {
      throw new YCoordinateOutOfRangeException("Coordinate y out of range: 0.."
        + image.getHeight());
    }
    return image.getRGB(coordinate.getxCoordinate(), coordinate.getY());
  }
}
