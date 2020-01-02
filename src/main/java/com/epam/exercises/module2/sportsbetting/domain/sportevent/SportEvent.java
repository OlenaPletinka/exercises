package com.epam.exercises.module2.sportsbetting.domain.sportevent;

import com.epam.exercises.module2.sportsbetting.domain.bet.Bet;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public abstract class SportEvent {
   private Result result;
   private List<Bet> bets;
   private String title;
   private LocalDate startDate;
   private LocalDate endDate;

}
