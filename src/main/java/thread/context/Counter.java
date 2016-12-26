package thread.context;

/**
 * volatile、
 * 两个线程同时加载count到线程内存中，两个个线程+1,先后写入同一值，但是期望应该是读-写-读-写，变成了读-读-写-写
 * Created by seyMour on 2016/12/26.
 */
public class Counter {

    //    public static int count = 0;
    public volatile static int count = 0;

    public static void inc() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            //lamda
            new Thread(Counter::inc).start();
        }
        //结果不为1000,即时加了volatile
        System.out.println(Counter.count);
    }
}
