package misc;

import banking.Account;
import banking.Bank;
import banking.Customer;
import banking.Movement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankTool {
    public void readFromFile(Bank bank, String filename) throws IOException {
        var lines = Files.readAllLines(Path.of(filename));
        parseStrings(bank, lines);
    }

    private void parseStrings(Bank bank, List<String> lines) {
        for (var line : lines) {
            if (line.startsWith("A:")) parseAccounts(bank, line);
            else if (line.startsWith("C:")) parseCustomers(bank, line);
            else if (line.startsWith("M:")) parseMovements(bank, line);
            else throw new RuntimeException();
        }
    }

    private void parseMovements(Bank bank, String line) {
        var movementParts = line.split(":");
        if (movementParts.length != 5) throw new RuntimeException();
        var sourceNumber = movementParts[0];
        var targetNumber = movementParts[1];
        long amount = Integer.parseInt(movementParts[2]);
        long timestamp = Integer.parseInt(movementParts[3]);
        var movement = new Movement(bank.getAccount(sourceNumber), bank.getAccount(targetNumber), amount, timestamp);
    }

    private void parseCustomers(Bank bank, String line) {
        var customerParts = line.split(":");
        if (customerParts.length != 3) throw new RuntimeException();
        Customer customer = new BaseCustomer(customerParts[0], customerParts[1]);
        bank.registerCustomer(customer);
    }

    private void parseAccounts(Bank bank, String line) {
        var parts = line.split(":");
        if (parts.length != 3) throw new RuntimeException();
        var account = new Account(bank, bank.getCustomer(parts[2]), parts[1]);
        bank.registerAccount(account);
    }

}