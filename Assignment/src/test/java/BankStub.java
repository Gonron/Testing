public class BankStub implements Bank {
    private Account account;

    @Override
    public Account getAccount(String number) {
        return account;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
