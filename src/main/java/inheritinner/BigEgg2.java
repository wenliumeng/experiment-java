package inheritinner;

class Egg2 {
    //3
    protected class Yolk {
        public Yolk() {System.out.println("Egg2.Yolk()");}
        public void f() {System.out.println("Egg2.Yolk.f()");}
    }

    //要生成Egg2的对象，先得执行类中的代码块
    //2
    private Yolk yolk = new Yolk();

    //1
    public Egg2() {
        //4
        System.out.println("new Egg2()");
    }

    //4
    public void insertYolk(Yolk yy){yolk = yy;}

    public void g() {yolk.f();}
}

public class BigEgg2 extends Egg2{

    public class Yolk extends Egg2.Yolk {
        //5
        public Yolk() {System.out.println("BigEgg2.Yolk()");}

        @Override
        public void f() {System.out.println("BigEgg2.Yolk.f()");}
    }

    //0
    public BigEgg2(){insertYolk(new Yolk());}

    public static void main(String[] args) {
        //要生成内部类的对象先得生成外部类的对象
        Egg2 e2 = new BigEgg2();
        /***
         Egg2.Yolk()
         new Egg2()
         Egg2.Yolk()
         BigEgg2.Yolk()
         */

        //被覆盖
        e2.g();
    }

}
