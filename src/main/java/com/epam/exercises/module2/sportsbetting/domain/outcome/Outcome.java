package com.epam.exercises.module2.sportsbetting.domain.outcome;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Outcome {

   private List<OutcomeOdd> outcomeOdds = new ArrayList<>();
   private String outcomeValue;


   public void addOutcomeOdd(OutcomeOdd outcomeOddForFirstOutcome) {
      outcomeOdds.add(outcomeOddForFirstOutcome);
   }
}
