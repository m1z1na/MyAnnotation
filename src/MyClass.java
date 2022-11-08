import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class MyClass implements InvocationHandler {

    private class MyLovelyImpl implements MyInterface {
    }

    private MyLovelyImpl myLovely = new MyLovelyImpl();


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!method.isAnnotationPresent(MyLovelyProfiler.class)) {
            return method.invoke(myLovely, args);
        }
        long time = System.currentTimeMillis();
        Object returnObj = method.invoke(myLovely, args);
        System.out.println( ((System.currentTimeMillis() - time) / 60) );

        return returnObj;
    }

}