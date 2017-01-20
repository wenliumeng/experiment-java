package javathread;

/**
 * 线程join
 * Created by seyMour on 2017/1/20.
 */

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        System.out.println(getName() + " create() ");
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " run() ");
            sleep(duration);
        } catch (Exception e) {
            System.out.println(getName() + " was interrupted. " + " isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        System.out.println(getName() + " create() ");
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " run() ");
            sleeper.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}

public class Joining {

    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleepy", 1500);
        Sleeper grumy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleeper);
        Joiner doc = new Joiner("Doc", grumy);
        grumy.interrupt();
    }
}
