package interclass3;

public class Outer {
    private String str = "init";
    private void print(){
        System.out.println("print()");
    }

    class Inter {
        void editOuter(){
            str = "outer edit";
            print();
        }

        private int secure = 1;
    }

    void edit(){
        Inter inter = new Inter();
        inter.editOuter();
        System.out.println(inter.secure);
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.edit();
        System.out.println(outer.str);
    }
}
