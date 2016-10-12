package latebinding;

public class PrivateOverride {

    private void f(){
        System.out.println("privateOverride.f()");
    }

    void g(){
        System.out.println("privateOverride.g()");
    }

    public static void main(String[] args) {
        PrivateOverride pri = new publicOverride();
        pri.f();
        pri.g();
        //结果必然是privateOverride.f(),因为被继承的类中的private方法默认是final，不可被复写
    }

}

class publicOverride extends PrivateOverride {

    public void f(){
        System.out.println("publicOverride.f()");
    }

    @Override
    void g() {
        System.out.println("publicOverride.g()");
    }
}
