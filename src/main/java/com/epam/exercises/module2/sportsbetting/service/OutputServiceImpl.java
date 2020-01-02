package com.epam.exercises.module2.sportsbetting.service;

import java.util.List;

public class OutputServiceImpl implements OutputService {

   private DataProcessorService dataProcessorService = new DataProcessorServiceImpl();

   @Override
   public void getBetsOutput() {
      List<OutputBetObject> outputBetObjects = dataProcessorService.createOutputBetObjects();
      for (int i = 1; i <= outputBetObjects.size(); i++) {
         OutputBetObject outputBetObject = outputBetObjects.get(i - 1);
         System.out.println(String.format(
             "%d: Bet on the %s sport event, %s. The odd on this is %.1f, valid from %s to %s", i,
             outputBetObject.getSportEventTitle(), outputBetObject.getOutcomeValue(),
             outputBetObject.getOutcomeOddValue(), outputBetObject.getFromDate(),
             outputBetObject.getToDate()));
      }
   }
}
