package com.epam.exercises.module3.cleancode.exersice1.services.impl;

import com.epam.exercises.module3.cleancode.exersice1.exceptions.FileNotFoundException;
import com.epam.exercises.module3.cleancode.exersice1.services.ImageLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageLoaderImpl implements ImageLoader {
  /**
   * method load image from the file.
   * @param fileName name of the file be downloaded.
   * @return object of the BufferedImage.class.
   */

  @Override
  public BufferedImage loadImageFromFile(String fileName) {
    try {
      return ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)));
    } catch (IOException exception) {
      throw new FileNotFoundException("File not found!", exception);
    }
  }
}
