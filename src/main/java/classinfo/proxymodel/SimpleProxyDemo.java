package classinfo.proxymodel;

/**
 * proxy
 * Created by seyMour on 2016/11/26.
 * ☞seyMour☜
 */

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimplePorxy implements Interface{
    private Interface proxy;

    public SimplePorxy(Interface proxy) {
        this.proxy = proxy;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxy.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxy.somethingElse(arg);
    }
}

public class SimpleProxyDemo {

    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimplePorxy(new RealObject()));
    }
}
