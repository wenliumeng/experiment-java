package javaenum;

import java.util.HashMap;

public class JavaEnum {

    //枚举用法-单例
    public enum Singleton {
        dataUpdata
    }

    //枚举用法-自定义字段和方法
    public enum enumTest {
        PLUS("+") {
            @Override
            int bind(int arg1, int arg2) {
                return arg1 + arg2;
            }
        },
        SUB("-") {
            @Override
            int bind(int arg1, int arg2) {
                return arg1 - arg2;
            }
        };

        String operation = "";

        enumTest(String operation) {
            this.operation = operation;
        }

        abstract int bind(int arg1, int arg2);
    }

    //枚举用法-实现接口
    interface Operation {
        int operate(int arg1, int arg2);
    }

    public enum enumTest2 implements Operation {
        PLUS("+") {
            @Override
            public int operate(int arg1, int arg2) {
                return arg1 + arg2;
            }
        },
        SUB("-") {
            @Override
            public int operate(int arg1, int arg2) {
                return arg1 - arg2;
            }
        };

        String operation;

        enumTest2(String operation) {
            this.operation = operation;
        }

        @Override
        public int operate(int arg1, int arg2) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("dataUpdata".equals(Singleton.dataUpdata.name()));

        System.out.println(enumTest.PLUS.bind(1, 2) + " " + enumTest.SUB.bind(2, 1));

        HashMap<String,enumTest2> hashmap = new HashMap<>();
        hashmap.put("+", enumTest2.PLUS);
        hashmap.put("-", enumTest2.SUB);
        Operation operation = hashmap.get("+");
        System.out.println(operation.operate(1,2));
    }
}
