package dk.cphbusiness.backend;
import dk.cphbusiness.backend.doubles.AccountStub;
import dk.cphbusiness.backend.doubles.CustomerStub;
import dk.cphbusiness.backend.models.RealAccount;
import dk.cphbusiness.backend.models.RealBank;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RealBankTest {

    @Test
    public void testCreateBank() {
        String cvr = "12345678";
        RealBank rb = new RealBank(cvr, "Nordea");
        assertNotNull(rb);
        assertEquals("Nordea", rb.getName());
    }

    @Test
    public void testRegisterAndGetAccount() {
        //Arrange
        String cvr = "12345678";
        RealBank rb = new RealBank(cvr, "Nordea");
        var customerStub = new CustomerStub("100895-6666", "Adam Saidane");
        var account1 = new AccountStub(rb, customerStub, "2123FEL");
        var account2 = new AccountStub(rb, customerStub, "3345FEL");

        //Act
        rb.registerAccount(account1);
        rb.registerAccount(account2);

        //Assert
        assertEquals(account1, rb.getAccount("2123FEL"));
        assertEquals(account2, rb.getAccount("3345FEL"));
    }

    @Test
    public void testRegisterAndGetCustomer() {
        //Arrange
        String cvr = "12345678";
        RealBank rb = new RealBank(cvr, "Nordea");
        var customer = new CustomerStub("100895-6666", "Adam Saidane");
        //Act
        rb.registerCustomer(customer);
        //Assert
        assertEquals(customer, rb.getCustomer("100895-6666"));
    }

    @Test
    public void testGetAccounts() {
        //Arrange
        String cvr = "12345678";
        RealBank rb = new RealBank(cvr, "Nordea");
        var customer = new CustomerStub("100895-6666", "Adam Saidane");
        var account1 = new AccountStub(rb, customer, "2123FEL");
        var account2 = new AccountStub(rb, customer, "3345FEL");
        //Act
        rb.registerAccount(account1);
        rb.registerAccount(account2);
        var customerAccounts = rb.getAccounts(customer);
        //Assert
        var expected = new ArrayList<RealAccount>() {{
            add(account1);
            add(account2);
        }};
        assertEquals(expected, customerAccounts);
        assertEquals(2, customerAccounts.size());
    }

}
