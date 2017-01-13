package hashcode;

public class HashCodeTest {


    public static void main(String[] args) {
        byte b = 12;
        int c = (int) b;
        System.out.println(c);
        long l = 9223372036854774800L;
        int c1 = (int) (l ^ (l >>> 32));
        System.out.println(l >>> 32);
        System.out.println(l >> 32);
        long c2 = l / (int) (Math.pow(2, 32));
        System.out.println(c2);
    }

}
