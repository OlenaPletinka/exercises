package com.epam.exercises.module3.cleancode.exersice2;

import com.epam.exercises.module3.cleancode.exersice2.utils.DateUtil;

import java.util.Date;
import java.util.logging.Logger;

public class DateApp {
  private static Logger logger = Logger.getLogger(DateApp.class.getName());

  /**
   * Main method of the application.
   * @param args argument of the method.
   */
  public static void main(String[] args) {
    final Date date = new Date();
    DateUtil.increment(date, false);

    logger.info(date.toString());

    logger.info(DateUtil.create(2014, 10, 10).toString());
  }
}
