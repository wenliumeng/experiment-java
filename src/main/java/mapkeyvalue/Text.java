package mapkeyvalue;

import java.util.HashMap;
import java.util.Map;

/**
 * Object1 测试类
 * Created by seymour on 2017/4/23.
 */
public class Text {
    public static void main(String[] args) {
        Object1 object1 = new Object1(234);
        Object1 object2 = new Object1(234);
        System.out.println(object1.hashCode() + " " + object2.hashCode());
        Map<Object1,String> map = new HashMap<>();
        map.put(object1,"object1");
        map.put(object2,"object2");
        //只覆盖hashcode不能确定mapkey的唯一性
        //不覆盖size 2
        //覆盖 size  1
        System.out.println(map.size());
    }
}
