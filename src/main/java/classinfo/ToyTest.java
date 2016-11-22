package classinfo;

/**
 * class.forName方法
 * Created by seyMour on 2016/11/22.
 * ☞Keenyoda☜
 */
interface HasBatteries {}
interface Waterproff {}
interface Shoots {}

class Toy {
    Toy(){}
    Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproff,Shoots{
    FancyToy(){super(1);}
}

public class ToyTest {

    static void printInfo(Class cc){
        System.out.println("Class name: " + cc.getName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("classinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find FancyToy");
            e.printStackTrace();
            System.exit(1);
        }
        printInfo(c);
        for (Class cc :
                c.getInterfaces()) {
            printInfo(cc);
        }

        Class up = null;
        up = c.getSuperclass();

        Object o = null;
        try {
            o = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        printInfo(o.getClass());
    }

}
