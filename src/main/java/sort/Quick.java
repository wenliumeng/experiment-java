package sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] l = new int[]{0, 4, 3, 2, 1, 9, 8, 7, 6, 5};
        quickSort(l, 1, 9);
        System.out.println(Arrays.toString(l));
    }

    static void quickSort(int i[], int low, int high) {
        int mid;
        if (low < high) {
            mid = gotomid(i, low, high);
            quickSort(i, low, mid - 1);
            quickSort(i, mid + 1, high);
        }
    }

    static int gotomid(int[] l, int low, int high) {
        int key = l[low];
        while (low < high) {
            while (high > low && l[high] >= key)
                high--;
            Bubble.swap(l, high, low);
            System.out.println(Arrays.toString(l));
            while (high > low && l[low] <= key)
                low++;
            Bubble.swap(l, high, low);
            System.out.println(Arrays.toString(l));
        }
        return low;
    }
}
