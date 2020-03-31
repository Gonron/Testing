package dk.cphbusiness.backend.contract;
import dk.cphbusiness.backend.models.Account;
import dk.cphbusiness.backend.models.Bank;
import static dk.cphbusiness.contract.AccountManager.*;
import static dk.cphbusiness.backend.contract.BankAssembler.*;
import static dk.cphbusiness.backend.contract.CustomerAssembler.*;
import static dk.cphbusiness.backend.contract.MovementAssembler.*;

import java.util.*;

import static dk.cphbusiness.contract.AccountManager.*;

public class AccountAssembler {

    public static AccountSummary createAccountSummary(Account account){
        return new AccountSummary(account.getNumber(), createBankSummary(account.getBank()), account.getBalance());
    }

    public static Map<String, AccountSummary> createAccountSummaries(Map<String, Account> accounts){
        var summaries = new HashMap<String, AccountSummary>();
        accounts.forEach((k,v) -> summaries.put(k, createAccountSummary(v)));
        return summaries;
    }

    public static AccountDetail createAccountDetail(Account account){
        return new AccountDetail(account.getNumber(),
                createBankSummary(account.getBank()),
                createCustomerSummary(account.getCustomer()),
                account.getBalance(),
                createMovementDetails(account.getMovements()));
    }
}