package dk.cphbusiness.contract;
import java.util.HashMap;
import java.util.Map;

public interface BankManager {

    class BankIdentifier {
        private final String cvr;

        public BankIdentifier(String cvr) {
            this.cvr = cvr;
        }

        public String getCvr() {
            return cvr;
        }

    }

    /**
     * Member details
     */
    class BankDetail extends BankIdentifier {
        private Map<String, AccountManager.AccountSummary> accounts = new HashMap<>();
        private Map<String, CustomerManager.CustomerSummary> customers = new HashMap<>();
        private String name;

        public BankDetail(String cvr, Map<String, AccountManager.AccountSummary> accounts, Map<String, CustomerManager.CustomerSummary> customers, String name) {
            super(cvr);
            this.accounts = accounts;
            this.customers = customers;
            this.name = name;
        }

        public Map<String, AccountManager.AccountSummary> getAccounts() {
            return accounts;
        }

        public void setAccounts(Map<String, AccountManager.AccountSummary> accounts) {
            this.accounts = accounts;
        }

        public Map<String, CustomerManager.CustomerSummary> getCustomers() {
            return customers;
        }

        public void setCustomers(Map<String, CustomerManager.CustomerSummary> customers) {
            this.customers = customers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Member summary
     */
    class BankSummary extends BankIdentifier {
        private String name;

        public BankSummary(String cvr, String name) {
            super(cvr);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}