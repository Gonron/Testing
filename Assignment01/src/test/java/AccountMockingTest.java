import banking.Account;
import banking.Bank;
import banking.Customer;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

public class AccountMockingTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testAccountTransfer() {
        final var customer = context.mock(Customer.class);
        final var bank = context.mock(Bank.class);
        final var targetNumber = "TGT54321";
        var source = new Account(bank, customer, "SRC54321");
        var target = new Account(bank, customer, targetNumber);
        context.checking(new Expectations(){{
            oneOf(bank).getAccount(targetNumber);
            will(returnValue(target));
            //oneOf(bank).getName();
        }});

        source.transfer(10000, "TGT54321");
        assertEquals(-10000, source.getBalance());
        assertEquals(10000, target.getBalance());

        //context.assertIsSatisfied();
    }

}