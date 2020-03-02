public class BankDummy implements Bank {

    @Override
    public Account getAccount(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }
}
