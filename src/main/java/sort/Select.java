package sort;

import java.util.Arrays;

/**
 * 简单选择
 * Created by seyMour on 2016/9/5.
 * ☞Keenyoda☜
 */
public class Select {

    public static void main(String[] args) {
        int[] l = new int[]{4, 3, 2, 1};
        for (int i = 0; i < l.length - 1; i++) {
            int min = i;
            for (int j = i; j < l.length - 1; j++) {
                if (l[min] > l[j + 1])
                    min = j + 1;
            }
            if (min != i)
                Bubble.swap(l, min, i);
        }
        System.out.println(Arrays.toString(l));
    }

}
