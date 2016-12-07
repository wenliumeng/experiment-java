package classinfo.interfaceinfo;

import classinfo.interfaceinfo.interfacea.A;
import classinfo.interfaceinfo.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {

    public static void main(String[] args) {
        A a = HiddenC.makeA();
        a.f();
        //实际是C转型成A
        System.out.println(a.getClass().getName());
        //这里无法转型为C，因为在包外没有任何C类型可用
        //C c = (C)a;

        //但是使用反射任然能调用所有的方法，即使是只发布编译后的代码，也能通过javap -private C来反编译突破限制
        //私有内部类和匿名类都不能阻止反射
        //私有内部类：类中使用 private C implement A
        //匿名类：makeA方法返回，return new A() {……实现…}
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }


    static void callHiddenMethod(Object a, String methodName) {
        try {
            Method m = a.getClass().getDeclaredMethod(methodName);
            m.setAccessible(true);
            try {
                m.invoke(a);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
