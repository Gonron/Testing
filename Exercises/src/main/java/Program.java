public class Program {

    public static void main(String[] args) {
        try {
            Runner runner = new Runner();
            runner.run(FooTest.class);
        }catch (Exception excep) {
            System.out.println(excep.getCause().getMessage());
        }
    }
}
