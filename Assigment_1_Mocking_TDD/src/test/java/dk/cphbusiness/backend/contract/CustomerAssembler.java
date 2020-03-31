package dk.cphbusiness.backend.contract;
import dk.cphbusiness.backend.models.Customer;
import dk.cphbusiness.contract.CustomerManager.*;

import java.util.List;

import static dk.cphbusiness.backend.contract.BankAssembler.*;

public class CustomerAssembler {
    public static CustomerSummary createCustomerSummary(Customer customer) {
        return new CustomerSummary(
                customer.getCpr(),
                customer.getName(),
                createBankSummary(customer.getBank())
        );
    }

    public static CustomerDetail createCustomerDetail(Customer customer) {
        return new CustomerDetail(
                customer.getCpr(),
                customer.getName(),
                createBankSummary(customer.getBank()),
                customer.getAccountNumbers()
        );
    }
}
