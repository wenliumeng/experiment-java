package staticexperiment;

/**
 * 先执行AB的静态代码，再生成A类和对象，
 */
public class ClassB extends ClassA {

    public ClassB()
    {
        System.out.println("Object B");
    }

    {
        System.out.println("Class B");
    }

    static {
        System.out.println("static B");
    }

    public static void main(String[] args) {
        new ClassB();
    }

}
