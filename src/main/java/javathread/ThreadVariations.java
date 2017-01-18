package javathread;

import java.util.concurrent.TimeUnit;

/**
 * xxx
 * Created by seyMour on 2017/1/18.
 */
public class ThreadVariations {

    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable("InnerRunnable1");
        new InnerRunnable1("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}

//using a named inner class
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (countDown-- == 0) return;
                    sleep(10);
                }
            } catch (Exception e) {

            }
        }

        @Override
        public String toString() {
            return getName() + " : " + countDown;
        }
    }
}

//using an anonymous inner class
class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (Exception e) {
                    System.out.println("sleep interrupted");
                }
            }

            @Override
            public String toString() {
                return getName() + " : " + countDown;
            }
        };
        t.start();
    }
}

//using a named Runnable implementation
class InnerRunnable {
    private int countDown = 5;
    private Inner inner;

    public InnerRunnable(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {

        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (Exception e) {
                System.out.println("sleep interrupted");
            }
        }

        @Override
        public String toString() {
            return t.getName() + " : " + countDown;
        }
    }
}

//using a anonymous Runnable implementation
class InnerRunnable1 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable1(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (Exception e) {
                    System.out.println("sleep interrupted");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + " : " + countDown;
            }
        }, name);
        t.start();
    }
}

//separate method to run
class ThreadMethod {
    private int countdown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countdown == 0) return;
                            sleep(10);
                        }
                    } catch (Exception e) {
                        System.out.println("sleep interrupted");
                    }
                }

                @Override
                public String toString() {
                    return getName() + " : " + countdown;
                }
            };
            t.start();
        }
    }
}