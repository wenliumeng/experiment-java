package classinfo;

import java.util.Random;

/**
 * 类的初始化
 * Created by seyMour on 2016/11/22.
 * ☞seyMour☜
 */

class Initable {
    static final int staticfinal = 1;
    static final int staitcfinal1 = classInitialization.rand.nextInt(1000);
    static {
        System.out.println();
        System.out.println("初始化Initable");
        System.out.println();
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println();
        System.out.println("初始化Initable2");
        System.out.println();
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println();
        System.out.println("初始化Initable3");
        System.out.println();
    }
}

public class classInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) {
        //仅适用.class语法不会进行初始化，这里不会输出static中的内容，但是使用Class.forName就会进行初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");

        //没有初始化也能访问
        System.out.println("Initable.staticfinal:"+Initable.staticfinal);

        //这里必须初始化才能访问
        System.out.println("Initable.staitcfinal1:"+Initable.staitcfinal1);

        System.out.println("Initable2.staticNonFinal: " + Initable2.staticNonFinal);

        try {
            Class initable3 = Class.forName("classinfo.Initable3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("After creating Initable3 ref");
        System.out.println(Initable2.staticNonFinal);
    }
}
