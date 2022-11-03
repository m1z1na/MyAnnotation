import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class MyClass implements InvocationHandler {

    private MyLovelyImpl examples = new MyLovelyImpl();
    private static class MyLovelyImpl implements MyInterface {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (!method.isAnnotationPresent(MyLovelyProfiler.class)) {
            return method.invoke(examples, args);
        }
        long time = System.currentTimeMillis();
        Object returnObj = method.invoke(examples, args);//вызывает сам себя
        System.out.println("Время работы сотавило: " + ((System.currentTimeMillis() - time) / 60) + " ");

        return returnObj;
    }

}