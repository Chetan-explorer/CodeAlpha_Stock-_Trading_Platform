package com.tradingapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
   private User user;
   private Stock stock;
   private TransactionType type;
   private int quantity;
   private BigDecimal price;
   private LocalDateTime timestamp;

   public Transaction(User user, Stock stock, TransactionType type, int quantity, BigDecimal price, LocalDateTime timestamp) {
      this.user = user;
      this.stock = stock;
      this.type = type;
      this.quantity = quantity;
      this.price = price;
      this.timestamp = timestamp;
   }

   // Getters
   public User getUser() { return user; }
   public Stock getStock() { return stock; }
   public TransactionType getType() { return type; }
   public int getQuantity() { return quantity; }
   public BigDecimal getPrice() { return price; }
   public LocalDateTime getTimestamp() { return timestamp; }
}