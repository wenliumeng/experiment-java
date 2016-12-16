package temp;

/**
 * 静态域属于类
 * Created by seyMour on 2016/12/16.
 * ☞seyMour☜
 */
public class temp1 {

    public static void main(String[] args) {
        System.out.println(new tempobj());
        System.out.println(new tempobj());
        Integer[][] a = new Integer[3][];
        System.out.println(a.length);
        System.out.println("-");
        for (int i = 0; i < a.length; i++){
            a[i] = new Integer[3];
            System.out.println(a[i].length);
        }
    }

}
