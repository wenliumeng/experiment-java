package interfaceconflict;


interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {
    @Override
    public void f() {

    }

    @Override
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    @Override
    public int f(int i) {
        return 1;
    }
}

class C4 extends C implements I3 {
    @Override
    public int f() {
        return 1;
    }
}

//覆盖，重载不能仅通过返回值类型来区分，IDE直接编译不通过
class C5 extends C implements I2 {
}

interface I4 extends I1, I3 {
}

