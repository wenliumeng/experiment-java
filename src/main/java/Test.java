import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.map.LinkedMap;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Test {

    int i = 0;

    Test increment() {
        i++;
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
