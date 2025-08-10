package com.tradingapp;

import com.tradingapp.model.User;
import com.tradingapp.model.Stock;
import com.tradingapp.service.TradingService;
import com.tradingapp.service.MarketDataService;

import java.math.BigDecimal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
   public static void main(String[] args) {
      // Initialize services and a user
      MarketDataService marketDataService = new MarketDataService();
      TradingService tradingService = new TradingService();
      User user = new User("Sham Sharma", new BigDecimal("10000.00"));

      // Simulate market data updates every 5 seconds
      ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
      scheduler.scheduleAtFixedRate(marketDataService::updateStockPrices, 0, 5, TimeUnit.SECONDS);

      // Display initial state
      System.out.println("Initial Portfolio for " + user.getUsername() + " :");
      System.out.println("Balance: $" + user.getBalance());
      System.out.println("\nAvailable Stocks :");
      marketDataService.getAvailableStocks().forEach(System.out::println);

      // Trading simulation after a short delay
      try {
         Thread.sleep(6000); // Wait for one market update
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      System.out.println("\n--- Trading in action ---");
      Stock appleStock = marketDataService.getAvailableStocks().stream()
               .filter(s -> "AAPL".equals(s.getTickerSymbol()))
               .findFirst().orElseThrow();

      // Attempt a buy
      tradingService.buyStock(user, appleStock, 10);

      // Display updated portfolio
      System.out.println("\nPortfolio after purchase:");
      System.out.println("Balance: $" + user.getBalance());
      user.getPortfolio().forEach((ticker, quantity) ->
               System.out.println("Stock: " + ticker + ", Quantity: " + quantity));
   }
}