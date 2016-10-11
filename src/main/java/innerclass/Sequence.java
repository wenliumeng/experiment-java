package innerclass;

public class Sequence {
    private Object[] items;
    private int next = 0;
    private String text2 = "";

    public Sequence(int size, String text2) {
        items = new Object[size];
        this.text2 = text2;
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }

        public void print(){
            System.out.println(text2);
        }
    }

    class Inter {
        public void print(){
            System.out.println(text2);
        }

        public Sequence getSequence(){
            return Sequence.this;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Inter inter(){
        return new Inter();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5,"dd");
        for (int i = 0; i < 5; i++)
            sequence.add(i + "");
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        Sequence sequence1 = new Sequence(5,"ddd");
        for (int i = 0; i < 5; i++)
            sequence1.add(new Text1());
        Selector selector1 = sequence1.selector();
        while (!selector1.end()) {
            ((Text1) selector1.current()).print();
            selector1.next();
        }

        Inter inter = sequence1.inter();
        inter.print();
        //通过内部类对象取得外部类对象的引用
        Sequence sequence2 = inter.getSequence();
        //通过外部类对象生成内部类对象，没有外部类对象之前是不可能有内部类对象的，嵌套类（静态内部类）除外
        Sequence.Inter inter1 = sequence2.new Inter();
    }
}
