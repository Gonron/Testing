package banking;

import java.util.HashMap;
import java.util.Map;

public class RealBank implements Bank {
    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account getAccount(String number) {
        return accounts.get(number);
    }

    @Override
    public void registerAccount(Account account) {
        accounts.put(account.getNumber(), account);
    }

    @Override
    public Customer getCustomer(String number) {
        return null;
    }

    @Override
    public void registerCustomer(Customer customer) {

    }

    @Override
    public String getName() {
        return null;
    }
}
