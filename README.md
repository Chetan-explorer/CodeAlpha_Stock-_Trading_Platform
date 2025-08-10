# Stock Trading Platform Simulation
This project is a simple command-line application that simulates a basic stock trading environment. It's built in Java and demonstrates core Object-Oriented Programming (OOP) principles.

## Features
- **Simulated Market**: The application simulates a dynamic stock market with a few predefined stocks. Prices are updated randomly at a fixed interval to mimic real-world fluctuations.
- **User Portfolio**: Users can track their account balance and the number of shares they own for each stock in their portfolio.
- **Trading Operations**: The platform allows users to perform `buy` and `sell` operations on stocks, with basic validation to ensure the user has enough funds or shares for the transaction.
- **Transaction History**: All buy and sell operations are recorded, providing a historical log of trades.
- **Object-Oriented Design**: The code is structured using a clear object-oriented approach with separate classes for core entities like `Stock`, `User`, and `Transaction`, as well as services for business logic.

## Project Structure
The project is organized into three main packages to maintain a clean and logical structure:

- `com.tradingapp`: Contains the main entry point for the application (`Main.java`).
- `com.tradingapp.model`: Holds all the data model classes, such as `Stock.java`, `User.java`, `Transaction.java`, and `TransactionType.java`.
- `com.tradingapp.service`: Contains the business logic and services, including `TradingService.java` (for handling trades) and `MarketDataService.java` (for managing market data).

## How to Compile and Run
### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Command Line Instructions
1.  **Navigate to the project's main source directory**:
    ```bash
    cd StockTradingPlat/src/main/java
    ```
2.  **Compile all the Java files**:
    ```bash
    javac -d ../../../bin com/tradingapp/*.java com/tradingapp/model/*.java com/tradingapp/service/*.java
    ```
3.  **Run the application**:
    ```bash
    cd ../../../bin
    java com.tradingapp.Main
    ```
