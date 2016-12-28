package designpattern.observer;

/**
 * 观察者模式测试类
 * Created by seyMour on 2016/12/28.
 */
public class ObserverTest {

    public static void main(String[] args) {
        MinaHandler minaHandler = new MinaHandler();
        minaHandler.connect();
        Device device = new Device();
        try {
            Thread.sleep(3000);
            minaHandler.addMonitorDevice(device, "d");
            Thread.sleep(3000);
            minaHandler.addMonitorDevice(device, "a");
            Thread.sleep(3000);
            minaHandler.addMonitorDevice(device, "c");
            Thread.sleep(3000);
            minaHandler.removeMonitorDevice(device, "a");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
