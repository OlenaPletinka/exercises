package com.epam.exercises.module3.cleancode.exersice2.utils;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;



/**
 * Utils class for creations date object using Calendar class.
 */
public final class DateUtil {
  /**
   * Privat constructor to make this class as utils.
   */
  private DateUtil() {
  }

  /**
   * This method increase given date.
   *
   * @param date the calendar field.
   * @param amount the amount of date or time to be added to the field.
   */
  public static void increment(final Date date, final boolean amount) {
    date.setTime(getCalendar(date, amount).getTime().getTime());
  }

  /**
   * This method create Calendar instance using.
   *
   * @param year the date field.
   * @param month the date field.
   * @param day the date field.
   * @return Date
   */
  public static Date create(final int year, final int month, final int day) {
    final Calendar calendar = getInstance();
    calendar.set(YEAR, year);
    calendar.set(MONTH, month);
    calendar.set(DAY_OF_MONTH, day);
    return calendar.getTime();
  }

  private static Calendar getCalendar(final Date date, final boolean amount) {
    final Calendar calendar = getInstance();
    calendar.setTime(date);
    calendar.add(DATE, amount ? 1 : -1);
    calendar.set(HOUR, 0);
    calendar.set(MINUTE, 0);
    calendar.set(SECOND, 0);
    calendar.set(MILLISECOND, 0);
    return calendar;
  }
}
