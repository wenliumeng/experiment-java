package sort;

import java.util.Arrays;

/**
 * 快速插入
 * Created by seyMour on 2016/9/5.
 * ☞Keenyoda☜
 */
public class Insert {

    public static void main(String[] args) {
        int[] l = new int[]{0, 4, 3, 2, 1};
        for (int i = 0; i < l.length - 2; i++) {
            if (l[i + 2] < l[i + 1]) {
                l[0] = l[i + 2];
                int j;
                for (j = i + 2; l[j - 1] > l[0]; j--) {
                    l[j] = l[j - 1];
                }
                l[j] = l[0];
            }
        }
        System.out.println(Arrays.toString(l));
    }

}
