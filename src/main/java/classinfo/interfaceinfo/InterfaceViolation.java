package classinfo.interfaceinfo;

import classinfo.interfaceinfo.interfacea.A;

/*
 B对象转型调用g()
 */
class B implements A {
    public void f() {
    }

    public void g() {
    }
}

public class InterfaceViolation {

    public static void main(String[] args) {
        A a = new B();
        a.f();
        //向上转型为A，没有g()方法
        //a.g();
        System.out.println(a.getClass().getName());
        if (a instanceof B) {
            B b = (B) a;
            //a向上转型，可以调用不在A中的g()方法，耦合超过预期
            b.g();
        }
    }
}
