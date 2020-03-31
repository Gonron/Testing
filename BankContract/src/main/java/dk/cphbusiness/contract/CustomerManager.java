package dk.cphbusiness.contract;
import java.util.List;

public interface CustomerManager {
    CustomerDetail getCustomer(String cpr);

    class CustomerIdentifier {
        private final String cpr;

        public CustomerIdentifier(String cpr) {
            this.cpr = cpr;
        }

        public String getCpr() {
            return cpr;
        }

    }

    /**
     * Member details
     */
    class CustomerDetail extends CustomerIdentifier {
        private String name;
        private BankManager.BankSummary bank;
        private List<String> accountNumbers;

        public CustomerDetail(String cpr, String name, BankManager.BankSummary bank, List<String> accountNumbers) {
            super(cpr);
            this.name = name;
            this.bank = bank;
            this.accountNumbers = accountNumbers;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BankManager.BankSummary getBank() {
            return bank;
        }

        public void setBank(BankManager.BankSummary bank) {
            this.bank = bank;
        }

        public List<String> getAccountNumbers() {
            return accountNumbers;
        }

        public void setAccountNumbers(List<String> accountNumbers) {
            this.accountNumbers = accountNumbers;
        }
    }

    /**
     * Member summary
     */
    class CustomerSummary extends CustomerIdentifier {
        private String name;
        private BankManager.BankSummary bank;

        public CustomerSummary(String cpr, String name, BankManager.BankSummary bank) {
            super(cpr);
            this.name = name;
            this.bank = bank;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BankManager.BankSummary getBank() {
            return bank;
        }

        public void setBank(BankManager.BankSummary bank) {
            this.bank = bank;
        }
    }
}
