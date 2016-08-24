/**
 * Created by Administrator on 2016/7/30.
 */
public class Test {

    int i = 0;

    Test increment() {
        i++;
        //this关键字只对方法有用，代表调用这个方法的对象
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.increment().increment().increment().print();
    }
}
