package com.epam.exercises.module2.sportsbetting.domain.wager;

import com.epam.exercises.module2.sportsbetting.domain.outcome.OutcomeOdd;
import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Wager {
   private OutcomeOdd outcomeOdd;
   private Player player;
   private BigDecimal amount;
   private Currency currency;
   private Integer timestamp;
   private boolean isProcessed;
   private boolean isWin;

   public Wager(OutcomeOdd outcomeOdd, Player player, BigDecimal amount, Currency currency,
       Integer timestamp, boolean isProcessed, boolean isWin) {
      this.outcomeOdd = outcomeOdd;
      this.player = player;
      this.amount = amount;
      this.currency = currency;
      this.timestamp = timestamp;
      this.isProcessed = isProcessed;
      this.isWin = isWin;
   }
}
