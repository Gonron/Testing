package dk.cphbusiness.backend.doubles;
import dk.cphbusiness.backend.models.Account;
import dk.cphbusiness.backend.models.RealAccount;
import dk.cphbusiness.backend.models.Bank;
import dk.cphbusiness.backend.models.Customer;

import java.util.List;

public class BankDummy implements Bank {
    @Override
    public RealAccount getAccount(String number) {
        throw new UnsupportedOperationException();
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
    public List<Account> getAccounts(Customer customer) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getCvr() {
        return null;
    }
}
