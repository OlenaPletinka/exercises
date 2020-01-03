package com.epam.exercises.module2.sportsbetting.domain.outcome;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OutcomeOdd {

   private Outcome outcome;
   private Double value;
   private LocalDate fromDate;
   private LocalDate toDate;
}
