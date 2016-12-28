package designpattern.observer;

import java.util.Observable;

public class Device extends Observable {

    String id = "3";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
