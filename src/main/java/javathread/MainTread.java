package javathread;

/**
 * 基本线程机制
 * Created by seyMour on 2017/1/17.
 */
public class MainTread {
    public static void main(String[] args) {
        /*LiftOff liftOff = new LiftOff();
        liftOff.run();*/

        //将Runnable转变为工作任务
        /*Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");*/

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }

    }
}
