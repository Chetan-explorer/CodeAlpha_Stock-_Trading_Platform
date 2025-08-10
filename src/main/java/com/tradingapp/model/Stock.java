package com.tradingapp.model;

import java.math.BigDecimal;

public class Stock {
   private String tickerSymbol;
   private String companyName;
   private BigDecimal currentPrice;

   public Stock(String tickerSymbol, String companyName, BigDecimal currentPrice) {
      this.tickerSymbol = tickerSymbol;
      this.companyName = companyName;
      this.currentPrice = currentPrice;
   }

   // Getters and Setters
   public String getTickerSymbol() { return tickerSymbol; }
   public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
   public String getCompanyName() { return companyName; }
   public void setCompanyName(String companyName) { this.companyName = companyName; }
   public BigDecimal getCurrentPrice() { return currentPrice; }
   public void setCurrentPrice(BigDecimal currentPrice) { this.currentPrice = currentPrice; }

   @Override
   public String toString() {
      return "Stock{" +
               "tickerSymbol='" + tickerSymbol + '\'' +
               ", companyName='" + companyName + '\'' +
               ", currentPrice=" + currentPrice +
               '}';
   }
}