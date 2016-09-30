package staticexperiment;

public class Static1 {

    //按理来说static方法是不能调用非静态方法的，因为static不依赖对象，随时都存在
    //但其实static方法内部是可以调用非静态方法和非静态成员的，引用传递(一旦发生传递，即代表生成了类的对象)
    static void test(Person person){
        person.eat();
    }

    public static void main(String[] args) {
        Person person =  new Person();
        test(person);
    }
}
