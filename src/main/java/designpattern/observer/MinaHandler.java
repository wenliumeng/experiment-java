package designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 监控端  观察者
 * Created by seyMour on 2016/12/28.
 */
public class MinaHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者受到信息，开始进行处理 ");
    }
}
