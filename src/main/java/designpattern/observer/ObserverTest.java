package designpattern.observer;

/**
 * 观察者模式测试类
 * Created by seyMour on 2016/12/28.
 */
public class ObserverTest {

    public static void main(String[] args) {

        InitObservable sub = new InitObservable();
        sub.connect();
        sub.addObserver(new MinaHandler());
        sub.addListenerDevice("a");
        sub.setChanged();

        try {
            Thread.sleep(3000);
            sub.addListenerDevice("d");
            sub.setChanged();
            Thread.sleep(3000);
            sub.addListenerDevice("ee");
            sub.setChanged();
            Thread.sleep(3000);
            sub.removeListenerDevice("d");
            sub.setChanged();
            Thread.sleep(3000);
            sub.addListenerDevice("dd");
            sub.setChanged();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
