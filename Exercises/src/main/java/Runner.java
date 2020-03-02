import java.lang.reflect.Method;

public class Runner {

    public void run(Class clss) throws Exception {
        /*
        Constructor<?> constructor = ((Class<?>) clss).getConstructor();
        Object instance = constructor.newInstance();
        */

        Method[] methods = clss.getMethods();
        Object obj = clss.getDeclaredConstructor().newInstance();

        for (Method method : methods) {
            if (!method.getName().startsWith("test")) continue;
            System.out.println("Invoking test methods: " + method.getName());
            method.invoke(obj);
        }
    }
}