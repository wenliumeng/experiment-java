package interclass5;

//必须在一个类中实现两个接口，可以有两种方式
interface A{}

interface B{}

class X implements A,B{}

class Y implements A{
    B makeB() {
        //
        return new B(){};
    }
}

public class MultiInterfaces {
    static void tasksA(A a){}
    static void tasksB(B b){}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        tasksA(x);
        tasksA(y);

        tasksB(x);
        tasksB(y.makeB());
    }
}
