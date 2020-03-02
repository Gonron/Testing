import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountMockingTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void testAccountTransfer() {
        final Customer customer = context.mock(Customer.class);
        final Bank bank = context.mock(Bank.class);
        final String targetNumber = "TAR12345";

        Account source = new Account(bank, customer, "SRC12345");
        Account target = new Account(bank, customer, targetNumber);

        context.checking(new Expectations() {{
            oneOf(bank).getAccount(targetNumber);
            will(returnValue(target));
        }});

        source.transfer(10000, targetNumber);
        assertEquals(10000,target.getBalance());
        assertEquals(-10000, source.getBalance());
    }
}
