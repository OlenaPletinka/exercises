package com.epam.exercises.module2.sportsbetting.service;

import java.time.LocalDate;
import lombok.Data;

@Data
public class OutputBetObject {
   private String sportEventTitle;
   private String outcomeValue;
   private Double outcomeOddValue;
   private LocalDate fromDate;
   private LocalDate toDate;

   public OutputBetObject(String sportEventTitle, String outcomeValue, Double outcomeOddValue,
       LocalDate fromDate, LocalDate toDate) {
      this.sportEventTitle = sportEventTitle;
      this.outcomeValue = outcomeValue;
      this.outcomeOddValue = outcomeOddValue;
      this.fromDate = fromDate;
      this.toDate = toDate;
   }
}
