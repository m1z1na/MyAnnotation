import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        MyInterface myclass = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new MyClass());
        myclass.GetWithoutMyLovelyProfiler("GetWithoutMyLovelyProfiler");
        myclass.GetWithMyLovelyProfiler("GetWithMyLovelyProfiler");
        myclass.GetWithoutMyLovelyProfiler("GetWithoutMyLovelyProfiler2");
    }
}