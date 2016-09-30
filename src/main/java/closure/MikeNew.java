package closure;

/**
 *
 * java8 lambda实现
 *
 */
public class MikeNew {
    public static final String name = "牛奶";

    public static int num = 11;

    public meal HaveMeal() {
        return (int cc) -> num = num - cc;
    }

    public void crurrent() {
        System.out.println("现在还有 ：" + num);
    }
}

interface meal {
    void drink(int ss);
}