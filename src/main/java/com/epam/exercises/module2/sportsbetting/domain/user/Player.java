package com.epam.exercises.module2.sportsbetting.domain.user;

import com.epam.exercises.module2.sportsbetting.enums.Currency;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Player extends User{
   private String name;
   private String accountNumber;
   private BigDecimal balance;
   private Currency currency;
   private LocalDate birth;

   public Player(String name, String accountNumber, BigDecimal balance, Currency currency,
       LocalDate birth) {
      this.name = name;
      this.accountNumber = accountNumber;
      this.balance = balance;
      this.currency = currency;
      this.birth = birth;
   }

   @Override
   public String toString() {
      return "Player{" + "name='" + name + '\'' + ", accountNumber='" + accountNumber + '\''
          + ", balance=" + balance + ", currency=" + currency + ", birth=" + birth + '}';
   }
}
