package designpattern.observer;

import java.util.Observable;

/**
 * 被观察者
 * Created by seyMour on 2016/12/28.
 */
abstract class SubjectObservable extends Observable {

    public abstract void addListenerDevice(String str);

    public abstract void removeListenerDevice(String str);
}
