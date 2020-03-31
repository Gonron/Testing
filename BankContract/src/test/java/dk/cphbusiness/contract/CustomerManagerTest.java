package dk.cphbusiness.contract;

import org.junit.Test;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

import static dk.cphbusiness.contract.CustomerManagerHolder.*;
import static dk.cphbusiness.contract.CustomerManager.*;

public class CustomerManagerTest {
    @Test
    public void testGetCustomer() {
        assumeThat(customerManager, not(nullValue()));
        var cpr = "0101010001";
        CustomerDetail customerDetail = customerManager.getCustomer(cpr);
        assertEquals(customerDetail.getCpr(), cpr);
    }
}
