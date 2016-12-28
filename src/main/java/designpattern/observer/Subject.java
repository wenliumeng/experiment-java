package designpattern.observer;

/**
 * 被观察者
 * Created by seyMour on 2016/12/28.
 */
abstract class Subject {

    private InitObserver initObserver = new InitObserver();

    protected void notifyObserver(Device device, String str) {
        initObserver.update(device, str);
    }

    public abstract void addMonitorDevice(Device device, String str);

    public abstract void removeMonitorDevice(Device device, String str);

}
