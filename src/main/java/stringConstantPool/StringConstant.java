package stringConstantPool;

/**
 * xxx
 * Created by seyMour on 2016/9/9.
 * ☞Keenyoda☜
 */
public class StringConstant {
    public static void main(String[] args) {
        String h1 = "Hello";
        String h2 = "Hello";
        System.out.println(h1 == h2);
        System.out.println(h1.equals(h2));
        String h3 = new String("Hello");
        String h4 = new String("Hello");
        System.out.println(h3 == h4);//比较引用，两边是不同的对象
        System.out.println(h3.equals(h4));//对象的内容
        String s = "lo";
        String s1 = "Hel" + s;
        String s2 = "Hel" + "lo";
        System.out.println(s1 == s2);//肯定不是同一个对象了
        System.out.println(s1.equals(s2));//但对象的内容还是一样的

        System.out.println(h1 == h3);//不是一个引用
        System.out.println(h1.equals(h3));//但具有相同的内容

        String a1 = "apple";
        String a2 = "app" +new String("le");
        System.out.println(a1==a2);//a2没有在字符串常量池中，不是同一个引用
        System.out.println(a1.equals(a2));

        String a3 = a2.intern();//把a2放入常量池中

        System.out.println(a1==a3);
    }
}
