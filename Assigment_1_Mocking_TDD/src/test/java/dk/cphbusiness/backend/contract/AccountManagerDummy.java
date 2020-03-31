package dk.cphbusiness.backend.contract;
import dk.cphbusiness.backend.doubles.ClockDummy;
import dk.cphbusiness.backend.models.*;
import dk.cphbusiness.contract.AccountManager;
import static dk.cphbusiness.contract.MovementManager.*;
import static dk.cphbusiness.backend.contract.MovementAssembler.*;
import static dk.cphbusiness.backend.contract.AccountAssembler.*;

import java.util.*;

public class AccountManagerDummy implements AccountManager {


    Map<String,Account> accounts;

    public AccountManagerDummy() {

        var bank = new RealBank("12345678", "Nordea");
        var customer = new RealCustomer("1008956666", "Adam", bank);
        var clock = new ClockDummy();
        var cpr1 = "0123456789";
        var cpr2 = "0012345678";
        accounts = new HashMap<>() {{
            put(cpr1, new RealAccount(bank, customer, cpr1, clock));
            put(cpr2, new RealAccount(bank, customer, cpr2, clock));
        }};

    }

    @Override
    public AccountDetail getAccount(String s) {
        return createAccountDetail(accounts.get(s));
    }

    @Override
    public Map<String, AccountSummary> getAccounts(String s) {
        return createAccountSummaries(accounts);
    }


    @Override
    public MovementDetail transfer(long amount, String sourceNumber, String targetNumber) {
        var source = accounts.get(sourceNumber);
        var target = accounts.get(targetNumber);
        source.transfer(amount, target);
        var movements = createMovementDetails(source.getMovements());
        var detail = movements.get(movements.size() - 1);
        return detail;
    }
}