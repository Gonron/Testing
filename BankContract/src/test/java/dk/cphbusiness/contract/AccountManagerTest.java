package dk.cphbusiness.contract;
import org.junit.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

public class AccountManagerTest {

    @Test
    public void testGetAccount(){
        assumeThat(AccountManagerHolder.accountManager, not(nullValue()));
        var accountNumber = "0123456789";
        AccountManager.AccountDetail account = AccountManagerHolder.accountManager.getAccount(accountNumber);
        assumeThat(account, not(nullValue()));
        assertEquals("0123456789", account.getNumber());
    }

    @Test
    public void testGetAccounts(){
        assumeThat(AccountManagerHolder.accountManager, not(nullValue()));
        var accounts = AccountManagerHolder.accountManager.getAccounts("1008956666");
        assumeThat(accounts, not(nullValue()));
        assertEquals(2, accounts.size());
    }

    @Test
    public void testTransfer(){
        assumeThat(AccountManagerHolder.accountManager, not(nullValue()));
        var sourceNumber = "0123456789";
        var source = AccountManagerHolder.accountManager.getAccount(sourceNumber);
        var targetNumber = "0012345678";
        AccountManagerHolder.accountManager.transfer(10000, sourceNumber, targetNumber);
        var target = AccountManagerHolder.accountManager.getAccount(targetNumber);
        source = AccountManagerHolder.accountManager.getAccount(sourceNumber);
        assertEquals(10000, target.getBalance());
        assertEquals(-10000, source.getBalance());
    }

}