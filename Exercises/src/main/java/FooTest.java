

public class FooTest {

    public void testFoo(){
        String foo = "Foo";
        String result = foo.toUpperCase();
        Actions.assertEquals("Result should be uppercase", result, "FOO");
        Actions.assertEquals("Length should not differ", result.length(), foo.length());
    }

    public void testBar(){
        System.out.println("Bar");
    }


}
