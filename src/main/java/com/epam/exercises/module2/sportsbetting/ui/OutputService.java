package com.epam.exercises.module2.sportsbetting.ui;

import com.epam.exercises.module2.sportsbetting.domain.outcome.Outcome;
import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.domain.wager.Wager;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface OutputService {

   List<OutputBetObject> getBetsOutput();

   void getResultOutput(Outcome winOutcome, Wager wager);

   void makeBet(BufferedReader bufferedReader, Player player) throws IOException;
}
