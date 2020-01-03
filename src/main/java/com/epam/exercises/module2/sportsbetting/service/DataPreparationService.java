package com.epam.exercises.module2.sportsbetting.service;

import com.epam.exercises.module2.sportsbetting.domain.bet.Bet;
import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.FootballSportEvent;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.SportEvent;
import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.enums.BetType;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface DataPreparationService {

   OutcomeOdd prepareOutcomeOdd(Double value, LocalDate fromdate, LocalDate toDate);

   Outcome prepareOutcome(String value, OutcomeOdd outcomeOdd);

   Bet prepareBet(SportEvent sportEvent, BetType betType, Outcome outcome);

   FootballSportEvent prepareFootballSportEvent(String title);

   Player createPlayer(String name, String accountNumber, BigDecimal balance, Currency currency,
       LocalDate birth);
}
