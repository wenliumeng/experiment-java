package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by seyMour on 2016/9/5.
 * ☞Keenyoda☜
 */
public class Bubble {

    public static void main(String[] args) {
        int[] l = new int[]{4, 3, 2, 1};
        for (int i = 0; i < l.length - 1; i++) {
            for (int j = 0; j < l.length - 1 - i; j++) {
                if (l[j] > l[j + 1]) {
                    swap(l, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(l));
    }

    public static void swap(int[] l, int i, int j) {
        int temp = l[i];
        l[i] = l[j];
        l[j] = temp;
    }
}
