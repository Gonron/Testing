import banking.Account;
import banking.Bank;
import banking.Customer;

public class AccountStub extends Account {
    public AccountStub(Bank bank, Customer customer, String number) {
        super(bank, customer, number);
    }
}
