package dk.cphbusiness.backend.contract;
import dk.cphbusiness.contract.AccountManagerHolder;
import dk.cphbusiness.contract.AccountManagerTest;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountManagerTest.class
})

public class AccountManagerDummyTest {
    @BeforeClass
    public static void setupClass(){
        AccountManagerHolder.accountManager = new AccountManagerDummy();
    }
}