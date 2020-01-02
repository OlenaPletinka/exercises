package com.epam.exercises.module2.sportsbetting;

import com.epam.exercises.module2.sportsbetting.domain.user.Player;
import com.epam.exercises.module2.sportsbetting.domain.user.PlayerBuilder;
import com.epam.exercises.module2.sportsbetting.enums.Currency;
import com.epam.exercises.module2.sportsbetting.service.OutputService;
import com.epam.exercises.module2.sportsbetting.service.OutputServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

public class App {

   private static OutputService outputService = new OutputServiceImpl();

   public static void main(String[] args) {
      System.out.println("Hi, what is your name?");
//      String line = null;

      try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

         String name = bufferedReader.readLine();

         System.out.println("What is your account number?");
         String accountNumber = bufferedReader.readLine();

         System.out.println("How much money do you have (more than 0)?");
         BigDecimal balance = new BigDecimal(bufferedReader.readLine());

         System.out.println("What is your currency? (UAH, EUR or USD)");
         Currency currency = Currency.valueOf(bufferedReader.readLine());

         System.out.println("When were you born? eg.:1990-02-03");
         LocalDate birth = LocalDate.parse(bufferedReader.readLine());

         PlayerBuilder playerBuilder = new PlayerBuilder();
         playerBuilder.setName(name).setAccountNumber(accountNumber).setBalance(balance)
             .setCurrency(currency).setBirth(birth);
         Player player = playerBuilder.createPlayer();

         System.out.println(
             "Welcome " + player.getName() + "!\n" + "Your balance is " + player.getBalance() + " "
                 + player.getCurrency());

         outputService.getBetsOutput();

      } catch (IOException e) {
         e.printStackTrace();
      }

   }

}
