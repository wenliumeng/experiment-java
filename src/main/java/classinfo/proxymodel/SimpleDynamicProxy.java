package classinfo.proxymodel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by seyMour on 2016/11/27.
 * ☞seyMour☜
 */

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** proxy:" + proxy.getClass() + ", method:" + method + "; args:" + args + " ***");
        if (args != null)
            for (Object o : args)
                System.out.println(o);
        return method.invoke(proxied, args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bobo");
    }

    public static void main(String[] args) {
        RealObject object = new RealObject();
        consumer(object);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(object)
        );
        consumer(proxy);
    }
}
