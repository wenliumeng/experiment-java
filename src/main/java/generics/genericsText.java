package generics;

import java.util.ArrayList;
import java.util.List;

class genericsT{

}

public class genericsText<T,PK> {

    public static void main(String[] args) {
//        genericsText c0 = new genericsText();
//        System.out.println(c0.getb());
//        genericsText<Integer,String> c = new genericsText();
//        //编译错误Integer无法转化为String
//        System.out.println(c.getb());
//        genericsText<Integer,Integer> c1 = new genericsText<>();
//        c1.geta("");
//        c1.geta(33);
//        c1.geta(new genericsT());
        new genericsText<>().getc(genericsText.class);
    }

    PK getb() {
        return (PK)new Integer(33);
    }

    //这个地方必须加<T>,不然参数类型中的T会默认为c1中的Integer
    <T> void geta(T t) {
        System.out.println(t.getClass().getName());
    }

    <T> Class<?> getc(Class<T> a) {
        System.out.println(a.getClass().getName());
        List<T> aa = new ArrayList<T>();
        System.out.println(aa);
        return a;
    }

}
