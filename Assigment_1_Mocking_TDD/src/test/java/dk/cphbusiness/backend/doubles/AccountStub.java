package dk.cphbusiness.backend.doubles;
import dk.cphbusiness.backend.models.RealAccount;
import dk.cphbusiness.backend.models.Bank;
import dk.cphbusiness.backend.models.Customer;

public class AccountStub extends RealAccount {
    public AccountStub(Bank bank, Customer customer, String number) {
        super(bank, customer, number, new ClockDummy());
        customer.getAccountNumbers().add(number);
    }
}
