package staticexperiment;


public class ClassA {

    public ClassA() {
        System.out.println("Object A");
    }

    {
        System.out.println("Class A");
    }

    static {
        System.out.println("Static A");
    }
}
