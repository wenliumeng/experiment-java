package singleton;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Soup {
    private Soup() {
    }

    private static Soup soup = new Soup();

    //只能通过这个方法得到对象
    public static Soup access(){
        return soup;
    }

    public void f(){
        System.out.println("method f()");
    }
}

