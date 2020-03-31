package dk.cphbusiness.backend.contract;

import dk.cphbusiness.backend.contract.CustomerManagerDummy;
import dk.cphbusiness.contract.CustomerManagerHolder;
import dk.cphbusiness.contract.CustomerManagerTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CustomerManagerTest.class
})

public class CustomerManagerDummyTest {
    @BeforeClass
    public static void setupClass() {
        CustomerManagerHolder.customerManager = new CustomerManagerDummy();
    }
}
