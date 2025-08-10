package com.tradingapp.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private BigDecimal balance;
    private Map<String, Integer> portfolio; // Ticker -> Quantity

    public User(String username, BigDecimal initialBalance) {
        this.username = username;
        this.balance = initialBalance;
        this.portfolio = new HashMap<>();
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
    public Map<String, Integer> getPortfolio() { return portfolio; }
    public void setPortfolio(Map<String, Integer> portfolio) { this.portfolio = portfolio; }
}