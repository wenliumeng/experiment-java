package javathread;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * Created by seyMour on 2017/1/17.
 */
public class SimpleDaemons implements Runnable {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("ALl Daemons started");
        try {
            TimeUnit.MILLISECONDS.sleep(175);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
