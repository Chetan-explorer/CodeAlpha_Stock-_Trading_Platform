package com.tradingapp.service;

import com.tradingapp.model.Stock;
import com.tradingapp.model.User;
import com.tradingapp.model.Transaction;
import com.tradingapp.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TradingService {

    private List<Transaction> transactionHistory = new ArrayList<>();

    public boolean buyStock(User user, Stock stock, int quantity) {
        BigDecimal totalCost = stock.getCurrentPrice().multiply(new BigDecimal(quantity));
        if (user.getBalance().compareTo(totalCost) >= 0) {
            // Deduct cost from balance
            user.setBalance(user.getBalance().subtract(totalCost));
            // Add stock to portfolio
            user.getPortfolio().merge(stock.getTickerSymbol(), quantity, Integer::sum);
            // Record transaction
            transactionHistory.add(new Transaction(user, stock, TransactionType.BUY, quantity, stock.getCurrentPrice(), LocalDateTime.now()));
            System.out.println("BUY successful: " + quantity + " shares of " + stock.getCompanyName());
            return true;
        } else {
            System.out.println("BUY failed: Insufficient balance.");
            return false;
        }
    }

    public boolean sellStock(User user, Stock stock, int quantity) {
        Integer currentQuantity = user.getPortfolio().getOrDefault(stock.getTickerSymbol(), 0);
        if (currentQuantity >= quantity) {
            BigDecimal totalRevenue = stock.getCurrentPrice().multiply(new BigDecimal(quantity));
            // Add revenue to balance
            user.setBalance(user.getBalance().add(totalRevenue));
            // Update portfolio
            user.getPortfolio().put(stock.getTickerSymbol(), currentQuantity - quantity);
            if (user.getPortfolio().get(stock.getTickerSymbol()) == 0) {
                user.getPortfolio().remove(stock.getTickerSymbol());
            }
            // Record transaction
            transactionHistory.add(new Transaction(user, stock, TransactionType.SELL, quantity, stock.getCurrentPrice(), LocalDateTime.now()));
            System.out.println("SELL successful: " + quantity + " shares of " + stock.getCompanyName());
            return true;
        } else {
            System.out.println("SELL failed: Not enough shares to sell.");
            return false;
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}