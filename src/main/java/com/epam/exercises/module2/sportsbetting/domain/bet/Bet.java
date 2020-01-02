package com.epam.exercises.module2.sportsbetting.domain.bet;

import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.SportEvent;
import com.epam.exercises.module2.sportsbetting.enums.BetType;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Bet {
   private SportEvent sportEvent;
   private List<Outcome> outcomes = new ArrayList<>();
   private String description;
   private BetType betType;

   public void addOutcome(Outcome outcome) {
      outcomes.add(outcome);
   }
}
