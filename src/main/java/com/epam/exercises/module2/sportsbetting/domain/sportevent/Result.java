package com.epam.exercises.module2.sportsbetting.domain.sportevent;

import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Result {

   private List<Outcome> outcomes = new ArrayList<>();


   public void addOutcomes(Outcome outcome) {
      outcomes.add(outcome);
   }
}
