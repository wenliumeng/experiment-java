package classinfo;

/**
 * 关于equal ==
 * Created by seyMour on 2017/2/21.
 * ☞seyMour☜
 */
public class Euqal {
    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        Integer c = 100, d = 100;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a.equals(b));
        System.out.println(c.equals(d));

        System.out.println();
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);


        System.out.println("-");
        Integer ad = new Integer(1000);
        int bd = 1000;
        Integer cd = new Integer(10);
        Integer dd = new Integer(10);
        System.out.println(ad == bd);//false,超过128，和缓存没关系，生成两个对象
        System.out.println(cd == dd);//false，封装对象，地址都不一样

        Integer cd_1 = Integer.valueOf(10);
        Integer dd_1 = Integer.valueOf(10);
        System.out.println(cd_1 == dd_1);
    }

    void mRun(String name) {
        new Runnable() {

            @Override
            public void run() {
                System.out.println(name);
            }
        }.run();
    }

}
