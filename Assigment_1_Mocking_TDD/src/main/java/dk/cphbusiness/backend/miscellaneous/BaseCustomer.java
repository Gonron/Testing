package dk.cphbusiness.backend.miscellaneous;

import dk.cphbusiness.backend.models.Bank;
import dk.cphbusiness.backend.models.Account;
import dk.cphbusiness.backend.models.Customer;

import java.util.List;

public class BaseCustomer implements Customer {
    public BaseCustomer(String number, String name) { }



    @Override
    public void transfer(long amount, Account account, Customer target) {

    }

    @Override
    public String getCpr() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getAccountNumbers() {
        return null;
    }

    @Override
    public void addAccountNumber(String accountNumber) {

    }

    @Override
    public Bank getBank() {
        return null;
    }
}