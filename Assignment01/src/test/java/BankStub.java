import banking.Bank;
import banking.Customer;

public class BankStub implements Bank {
    private Customer.Account account;

    @Override
    public Customer.Account getAccount(String number) {
        return account;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void setAccount(Customer.Account account) {
        this.account = account;
    }
}
