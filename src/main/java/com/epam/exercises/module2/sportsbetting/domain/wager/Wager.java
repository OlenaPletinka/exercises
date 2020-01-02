package com.epam.exercises.module2.sportsbetting.domain.wager;

import com.epam.exercises.module2.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Wager {
   private OutcomeOdd outcomeOdd;
   private Player player;
   private BigDecimal amount;
   private Currency currency;
   private LocalDate timestamp;
   private boolean isProcessed;
   private boolean isWin;


}
