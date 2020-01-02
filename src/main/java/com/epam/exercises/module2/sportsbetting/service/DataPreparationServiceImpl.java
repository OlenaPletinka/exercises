package com.epam.exercises.module2.sportsbetting.service;

import com.epam.exercises.module2.sportsbetting.domain.bet.Bet;
import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.FootballSportEvent;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.SportEvent;
import com.epam.exercises.module2.sportsbetting.enums.BetType;
import java.time.LocalDate;

public class DataPreparationServiceImpl implements DataPreparationService {

   @Override
   public OutcomeOdd prepareOutcomeOdd(Double value, LocalDate fromdate, LocalDate toDate) {
      OutcomeOdd outcomeOddForFirstOutcome = new OutcomeOdd();
      outcomeOddForFirstOutcome.setValue(value);
      outcomeOddForFirstOutcome.setFromDate(fromdate);
      outcomeOddForFirstOutcome.setToDate(toDate);
      return outcomeOddForFirstOutcome;
   }

   @Override
   public Outcome prepareOutcome(String value, OutcomeOdd outcomeOdd) {
      Outcome outcome = new Outcome();
      outcome.setOutcomeValue(value);
      outcome.addOutcomeOdd(outcomeOdd);
      return outcome;
   }

   @Override
   public Bet prepareBet(SportEvent sportEvent, BetType betType, Outcome outcome) {
      Bet bet = new Bet();
      bet.setSportEvent(sportEvent);
      bet.setBetType(betType);
      bet.addOutcome(outcome);
      return bet;
   }

   @Override
   public FootballSportEvent prepareFootballSportEvent(String title) {
      FootballSportEvent footballSportEvent = new FootballSportEvent();
      footballSportEvent.setTitle(title);
      return footballSportEvent;
   }
}
