import banking.Bank;
import banking.Customer;

public class BankDummy implements Bank {

    @Override
    public Customer.Account getAccount(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }
}
