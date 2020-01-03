package com.epam.exercises.module2.sportsbetting.ui.impl;

import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.sportevent.Result;
import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.domain.wager.Wager;
import com.epam.exercises.module2.sportsbetting.domain.wager.WagerBuilder;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import com.epam.exercises.module2.sportsbetting.service.DataProcessorService;
import com.epam.exercises.module2.sportsbetting.service.impl.DataProcessorServiceImpl;
import com.epam.exercises.module2.sportsbetting.ui.InputValidator;
import com.epam.exercises.module2.sportsbetting.ui.OutputBetObject;
import com.epam.exercises.module2.sportsbetting.ui.OutputService;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OutputServiceImpl implements OutputService {

   private static List<Wager> wagers = new ArrayList<>();
   private InputValidator inputValidator = new InputValidator();

   private DataProcessorService dataProcessorService = new DataProcessorServiceImpl();

   @Override
   public List<OutputBetObject> getBetsOutput() {
      List<OutputBetObject> outputBetObjects = dataProcessorService.createOutputBetObjects();
      System.out
          .println("Please choose an outcome to bet on! (choose a number or press q for quit)");
      for (int i = 1; i <= outputBetObjects.size(); i++) {
         OutputBetObject outputBetObject = outputBetObjects.get(i - 1);
         System.out.println(String.format(
             "%d: Bet on the %s sport event, %s. The odd on this is %f, valid from %s to %s", i,
             outputBetObject.getSportEventTitle(), outputBetObject.getOutcomeValue(),
             outputBetObject.getOutcomeOddValue(), outputBetObject.getFromDate(),
             outputBetObject.getToDate()));
      }
      return outputBetObjects;
   }

   @Override
   public void getResultOutput(Outcome winOutcome, Wager wager) {
      System.out.println("Results:");
      System.out.println(String
          .format("The winner is Outcome %d [outcomeOdds=%f and valid from %s to %s]",
              wager.getTimestamp(), wager.getOutcomeOdd().getValue(),
              wager.getOutcomeOdd().getFromDate(), wager.getOutcomeOdd().getToDate()));
      System.out.println(String.format("You have won %f %s",
          wager.getAmount().multiply(BigDecimal.valueOf(wager.getOutcomeOdd().getValue())),
          wager.getCurrency()));

   }

   @Override
   public void makeBet(BufferedReader bufferedReader, Player player) throws IOException {
      List<OutputBetObject> betsOutput = getBetsOutput();

      String firstBetOn = bufferedReader.readLine();
      inputValidator.validateFirstBetOn(firstBetOn);

      if (firstBetOn.equals("q")) {
         getResults(wagers);
         return;
      } else {
         int choice = Integer.parseInt(firstBetOn);
         System.out.println("How much do you want to bet on it? (q for quit)");
         BigDecimal firstBet = BigDecimal.valueOf(Long.parseLong(bufferedReader.readLine()));
         discardPlayer(player, firstBet);
         wagers.add(createWagger(player, firstBet, betsOutput.get(choice - 1), choice));
         makeBet(bufferedReader, player);
      }
   }

   private void getResults(List<Wager> wagers) {
      Random rand = new Random();
      Wager winWager = wagers.get(rand.nextInt(wagers.size()));
      wagers.forEach(wager -> wager.setProcessed(true));
      winWager.setWin(true);

      Result result = new Result();
      Outcome winOutcome = winWager.getOutcomeOdd().getOutcome();
      result.addOutcomes(winOutcome);

      getResultOutput(winOutcome, winWager);
   }


   private Wager createWagger(Player player, BigDecimal firstBet, OutputBetObject outputBetObject,
       Integer choice) {
      WagerBuilder wagerBuilder = new WagerBuilder();
      return wagerBuilder.setPlayer(player).setAmount(firstBet).setCurrency(player.getCurrency())
          .setTimestamp(choice).setOutcomeOdd(outputBetObject.getOutcomeOdd()).createWager();
   }

   private void discardPlayer(Player player, BigDecimal bet) {
      BigDecimal balance = player.getBalance();
      Currency currency = player.getCurrency();
      if (!inputValidator.isValidBet(balance, bet)) {
         System.out
             .println("You don't have enough money, your balance is " + balance + " " + currency);
      } else {
         BigDecimal currentBalance = balance.subtract(bet);
         player.setBalance(currentBalance);
         System.out.println("Your new balance is " + currentBalance + " " + currency);
      }
   }
}
