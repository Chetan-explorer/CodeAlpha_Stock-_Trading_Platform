package com.tradingapp.service;

import com.tradingapp.model.Stock;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MarketDataService {
   private List<Stock> availableStocks = new ArrayList<>();
   private Random random = new Random();

   public MarketDataService() {
      availableStocks.add(new Stock("AAPL", "Apple Inc.", new BigDecimal("150.00")));
      availableStocks.add(new Stock("GOOGL", "Alphabet Inc.", new BigDecimal("2500.00")));
      availableStocks.add(new Stock("AMZN", "Amazon.com, Inc.", new BigDecimal("3200.00")));
   }

   public List<Stock> getAvailableStocks() {
      return availableStocks;
   }

   public void updateStockPrices() {
      for (Stock stock : availableStocks) {
         BigDecimal priceChange = new BigDecimal(random.nextDouble() * 10 - 5); // Random change between -5 and +5
         BigDecimal newPrice = stock.getCurrentPrice().add(priceChange).setScale(2, RoundingMode.HALF_UP);
         if (newPrice.compareTo(BigDecimal.ZERO) > 0) {
               stock.setCurrentPrice(newPrice);
         }
      }
      System.out.println("Market data updated.\n");
   }
}