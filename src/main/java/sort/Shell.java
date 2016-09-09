package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * Created by seyMour on 2016/9/7.
 * ☞Keenyoda☜
 */
public class Shell {

    public static void main(String[] args) {
        int[] l = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int increment = l.length;
        System.out.println(increment / 3 + 1);
        do {
            // 4
            increment = increment / 3 + 1;
            for (int i = increment + 1; i < l.length; i++) {
                if (l[i] < l[i - increment]) {
                    l[0] = l[i];
                    int j;
                    for (j = i-increment; j > 0 && l[j] > l[0]; j = j -increment) {//条件里面不能出现j-increment
                        l[j+increment] = l[j];
                    }
                    l[j+increment] = l[0];
                }
            }
        } while (increment > 1);
        System.out.println(Arrays.toString(l));
    }

}
