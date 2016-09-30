package closure;

/**
 * xxx
 * Created by seyMour on 2016/9/29.
 * ☞Keenyoda☜
 */
public class ClosureJava {


    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        //java8中的lambda表达式
        new Thread(()->{
            System.out.println("hello");
        }).start();

    }
}
