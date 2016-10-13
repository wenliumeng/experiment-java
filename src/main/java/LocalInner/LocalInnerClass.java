package LocalInner;

interface Counter {
    int next();
}

public class LocalInnerClass {

    private int count = 0;

    Counter getCounter(String name) {
        //局部内部类,使用局部内部类而不使用匿名内部类的原因是可能要多次实例化
        class LocalCounter implements Counter {

            public LocalCounter() {
                System.out.println("LocalCounter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }

        }
        return new LocalCounter();
    }

    Counter getCounter2(String name) {
        //匿名内部类
        return new Counter() {
            {
                System.out.println("Counter()");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass innerClass = new LocalInnerClass();
        Counter c1 = innerClass.getCounter("Local inner  "),
                c2 = innerClass.getCounter2("Anonymous inner  ");
        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}
