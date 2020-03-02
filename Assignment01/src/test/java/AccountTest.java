import banking.Bank;
import banking.Customer;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testCreateAccount() throws Exception {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();
        String number = null;

        Customer.Account account = new Customer.Account(bank, customer, number);
        assertNotNull(account);
    }

    @Test
    public void testCreateAccountWithBank() {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();
        String number = null;

        Customer.Account account = new Customer.Account(bank, customer, number);
        assertEquals(bank, account.getBank());
        assertNotNull(account.getBank());
    }

    @Test
    public void testCreateAccountWithCustomer() {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();
        String number = null;

        Customer.Account account = new Customer.Account(bank, customer, number);
        assertEquals(customer, account.getCustomer());
        assertNotNull(account.getCustomer());
    }

    @Test
    public void testCreateAccountWithNumber() {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();
        String number = "ABC12345";

        Customer.Account account = new Customer.Account(bank, customer, number);
        assertEquals(number, account.getNumber());
        assertNotNull(account.getNumber());
    }

    @Test
    public void testCreateAccountWithZeroBalance() {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();
        String number = "ABC12345";

        Customer.Account account = new Customer.Account(bank, customer, number);
        assertEquals(0, account.getBalance());
        assertNotNull(account.getBalance());
    }

    @Test
    public void testTransferPositiveAmount() {
        Bank bank = new BankDummy();
        Customer customer = new CustomerDummy();

        Customer.Account source = new Customer.Account(bank, customer, "SRC12345");
        Customer.Account target = new Customer.Account(bank, customer, "TAR12345");
        source.transfer(10000, target);

        assertEquals(10000,target.getBalance());
        assertEquals(-10000, source.getBalance());
    }

    @Test
    public void testTransferPositiveAmountUsingNumber() {
        BankStub bank = new BankStub();
        Customer customer = new CustomerDummy();
        String targetNumber = "TAR12345";

        Customer.Account target = new Customer.Account(bank, customer, targetNumber);
        Customer.Account source = new Customer.Account(bank, customer, "SRC12345");
        bank.setAccount(target);

        source.transfer(10000, targetNumber);
        assertEquals(10000,target.getBalance());
        assertEquals(-10000, source.getBalance());
    }
}
