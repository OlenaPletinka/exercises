package com.epam.exercises.module2.sportsbetting.service;

import com.epam.exercises.module2.sportsbetting.domain.sportevent.SportEvent;
import com.epam.exercises.module2.sportsbetting.enums.BetType;
import com.epam.exercises.module2.sportsbetting.ui.OutputBetObject;
import java.util.List;

public interface DataProcessorService {

   List<OutputBetObject> createOutputBetObjects();

   OutputBetObject createOutputBetObject(SportEvent sportEvent, String outcomeValue,
       Double outcomeOddValue, BetType betType);

}
