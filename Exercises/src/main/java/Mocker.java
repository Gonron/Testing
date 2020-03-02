// 2

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Mocker implements InvocationHandler {
    private static HashMap<String, Object> expectations = new HashMap<>();
    private static Mocker mockerInvoked = null;
    private static Method methodInvoked = null;

    public static Object mock(Class clss) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        return Proxy.newProxyInstance(loader, new Class[] { clss }, new Mocker());
    }

    private static String keyOf(Method method){
        return method.toString() + ":" +
                Arrays.stream(method.getParameterTypes())
                .map( paramType -> paramType.toString())
                .collect(Collectors.joining("#"));
    }

    public static void when(Object value, Object result) {
        System.out.println("when called with " +  result);
        if (mockerInvoked == null || methodInvoked == null) throw new RuntimeException();
        String key = keyOf(methodInvoked);
        mockerInvoked.expectations.put(key, result);
        methodInvoked = null;
        mockerInvoked = null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String key = keyOf(method);

        if (expectations.containsKey(key)) {
            return expectations.get(key);
        }

        mockerInvoked = this;
        methodInvoked = method;
        System.out.println("You called " + method.getName() + " without expectations");
        return null;
    }

    public static void main(String[] args) {
        Bank bank = (Bank)Mocker.mock(Bank.class);
        Mocker.when(bank.getName(), "Gonners Bank");
        Mocker.when(bank.getManager(), "Michael");

        System.out.println(bank.getName() + " managed by " + bank.getManager());
    }
}
