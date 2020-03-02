public class AssertionException extends RuntimeException{
    private Object actual, expected;

    public AssertionException(String message, Object actual, Object expected) {
        super(message + " - Expected: " + expected + ", but got: " + actual);
        this.actual = actual;
        this.expected = expected;
    }

    public Object getActual() {
        return actual;
    }

    public Object getExpected() {
        return expected;
    }
}
