package closure;

/**
 * 内部类和接口实现闭包
 * Created by seyMour on 2016/9/29.
 * ☞Keenyoda☜
 */
public class Milk {
    public final static String name = "牛奶";
    public static int num = 11;

    public Milk() {
        System.out.println(name + ":11/每箱");
    }

    //闭包的目的是为了修改num的值
    public Active HaveMeals() {
        return new Active() {
            @Override
            public void drink() {
                if (num == 0) {
                    System.out.println("喝完了");
                }
                num--;
                System.out.println("喝了一瓶牛奶！");
            }
        };
    }

    public void currentNum(){
        System.out.println("还剩下 " + num);
    }
}

interface Active {
    void drink();
}