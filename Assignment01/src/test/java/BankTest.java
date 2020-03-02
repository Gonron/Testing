import banking.Customer;
import banking.RealBank;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void testCreateBank() {
        var rb = new RealBank();
        assertNotNull(rb);
    }

    @Test
    public void testGetAccount() {
        var bank = new RealBank();

    }

    @Test
    public void testRegisterAccount() {
        var bank = new RealBank();
        var customer = new CustomerDummy();
        var account = new AccountStub(bank, customer, "1234TEST");
        bank.registerAccount(account);
        assertEquals(bank.getAccount("1234TEST"), account);
    }
}
