package com.epam.exercises.module2.sportsbetting.domain.outcome;

import java.time.LocalDate;
import lombok.Data;

@Data
public class OutcomeOdd {

   private Double value;
   private LocalDate fromDate;
   private LocalDate toDate;


}
