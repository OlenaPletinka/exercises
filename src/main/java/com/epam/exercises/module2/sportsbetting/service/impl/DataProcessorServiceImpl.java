package com.epam.exercises.module2.sportsbetting.service.impl;

import com.epam.exercises.module2.sportsbetting.domain.bet.Bet;
import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.FootballSportEvent;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.SportEvent;
import com.epam.exercises.module2.sportsbetting.enums.BetType;
import com.epam.exercises.module2.sportsbetting.service.DataPreparationService;
import com.epam.exercises.module2.sportsbetting.service.DataProcessorService;
import com.epam.exercises.module2.sportsbetting.ui.OutputBetObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataProcessorServiceImpl implements DataProcessorService {

   private LocalDate fromdate = LocalDate.of(2016, 02, 03);
   private LocalDate toDate = LocalDate.of(2016, 02, 05);

   private DataPreparationService dataPreparationService = new DataPreparationServiceImpl();

   @Override
   public List<OutputBetObject> createOutputBetObjects() {
      FootballSportEvent footballSportEvent = dataPreparationService
          .prepareFootballSportEvent("Arsenal vs Chelsea");

      List<OutputBetObject> outputBetObjects = new ArrayList<>();
      outputBetObjects.add(
          createOutputBetObject(footballSportEvent, "the player Oliver Giroud will score 1", 10.0,
              BetType.PLAYERS_SCORE));
      outputBetObjects.add(
          createOutputBetObject(footballSportEvent, "the number of scored goals will be 3", 1.3,
              BetType.BETTING_FOR_GOALS));
      outputBetObjects.add(
          createOutputBetObject(footballSportEvent, "the winner will be Arsenal", 4.0,
              BetType.WINNER));

      return outputBetObjects;
   }

   @Override
   public OutputBetObject createOutputBetObject(SportEvent sportEvent, String outcomeValue,
       Double outcomeOddValue, BetType betType) {

      OutcomeOdd outcomeOdd = dataPreparationService
          .prepareOutcomeOdd(outcomeOddValue, fromdate, toDate);

      Outcome outcome = dataPreparationService.prepareOutcome(outcomeValue, outcomeOdd);

      outcomeOdd.setOutcome(outcome);

      Bet bet = dataPreparationService.prepareBet(sportEvent, betType, outcome);

      return new OutputBetObject(sportEvent.getTitle(), outcome, outcomeOdd, fromdate, toDate);
   }
}
