package com.epam.exercises.module3.cleancode.exersice1;

import com.epam.exercises.module3.cleancode.exersice1.domain.Image;
import com.epam.exercises.module3.cleancode.exersice1.services.impl.ImagePrinterImpl;

import java.io.IOException;

public class AdvancedAscii {
  public static void main(String[] args) throws IOException {
    ImagePrinterImpl imagePrinter = new ImagePrinterImpl();
    imagePrinter.printImage(Image.createImage());
  }
}
