package com.epam.exercises.module2.sportsbetting;

import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import com.epam.exercises.module2.sportsbetting.service.DataPreparationService;
import com.epam.exercises.module2.sportsbetting.service.impl.DataPreparationServiceImpl;
import com.epam.exercises.module2.sportsbetting.ui.InputValidator;
import com.epam.exercises.module2.sportsbetting.ui.OutputService;
import com.epam.exercises.module2.sportsbetting.ui.impl.OutputServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

public class App {

   private static InputValidator inputValidator = new InputValidator();
   private static DataPreparationService dataPreparationService = new DataPreparationServiceImpl();
   private static OutputService outputService = new OutputServiceImpl();

   public static void main(String[] args) {
      System.out.println("Hi, what is your name?");

      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

         String name = bufferedReader.readLine();
         inputValidator.validateName(name);

         System.out.println("What is your account number?");
         String accountNumber = bufferedReader.readLine();
         inputValidator.validateAccountNumber(accountNumber);

         System.out.println("How much money do you have (more than 0)?");
         String balanceInput = bufferedReader.readLine();
         inputValidator.validateBalanceInput(balanceInput);
         BigDecimal balance = new BigDecimal(balanceInput);

         System.out.println("What is your currency? (UAH, EUR or USD)");
         String currencyInput = bufferedReader.readLine();
         inputValidator.validateCurrencyInput(currencyInput);
         Currency currency = Currency.valueOf(currencyInput);

         System.out.println("When were you born? eg.:1990-02-03");
         String birthInput = bufferedReader.readLine();
         inputValidator.validateBirthInput(birthInput);
         LocalDate birth = LocalDate.parse(birthInput);

         Player player = dataPreparationService
             .createPlayer(name, accountNumber, balance, currency, birth);

         System.out.println(
             "Welcome " + player.getName() + "!\n" + "Your balance is " + player.getBalance() + " "
                 + player.getCurrency());
         outputService.makeBet(bufferedReader, player);

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
