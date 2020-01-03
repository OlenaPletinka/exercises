package com.epam.exercises.module2.sportsbetting.ui;

import com.epam.exercises.module2.sportsbetting.enums.Currency;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidAccountNumberException;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidBalanceInputException;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidBetInputException;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidBirthInputException;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidCurrencyInputException;
import com.epam.exercises.module2.sportsbetting.exceptions.InvalidNameInputException;
import java.math.BigDecimal;

public class InputValidator {

   public void validateName(String name) {
      if (!name.matches("^[a-zA-Z_ ]*$")) {
         throw new InvalidNameInputException(
             "Please, enter valid name. Name can contain only letters!");
      }
   }

   public void validateAccountNumber(String accountNumber) {
      if (!accountNumber.matches("^[0-9]*$")) {
         throw new InvalidAccountNumberException(
             "Please, enter valid account number. Account number can contain only numbers!");
      }
   }

   public void validateBalanceInput(String balanceInput) {
      if (!balanceInput.matches("^[0-9]+([.][0-9]*)?|[.][0-9]+$")) {
         throw new InvalidBalanceInputException("Please, enter valid balance!");
      }
   }

   public void validateCurrencyInput(String currencyInput) {
      if (!currencyInput.equals(Currency.EUR.getValue()) && !currencyInput
          .equals(Currency.UAH.getValue()) && !currencyInput.equals(Currency.USD.getValue())) {
         throw new InvalidCurrencyInputException(
             "Please, enter valid currency value. Possible values of the currency are: UAH, EUR or USD!");
      }
   }

   public void validateBirthInput(String birthInput) {
      if (!birthInput.matches("\\d{4}-\\d{2}-\\d{2}")) {
         throw new InvalidBirthInputException(
             "Please, enter valid birth value. Correct format of the birth date is YYYY-MM-DD!");
      }
   }

   public void validateFirstBetOn(String firstBetOn) {
      if (!firstBetOn.matches("^[0-9]*$") && !firstBetOn.equals("q")) {
         throw new InvalidBetInputException("Please, enter valid number or 'q' for quit");
      }
   }

   public boolean isValidBet(BigDecimal balance, BigDecimal firstBet) {
      if (balance.compareTo(firstBet) < 0) {
         return false;
      } else {
         return true;
      }
   }
}
