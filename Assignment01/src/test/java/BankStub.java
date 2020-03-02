import banking.Account;
import banking.Bank;
import banking.Customer;

public class BankStub implements Bank {
    private Account account;

    @Override
    public Account getAccount(String number) {
        return account;
    }

    @Override
    public void registerAccount(Account account) {

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
        throw new UnsupportedOperationException();
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
