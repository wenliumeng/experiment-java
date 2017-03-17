/**
 * 二分查找
 * Created by seyMour on 2017/3/17.
 * ☞seyMour☜
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,5,8,11,19,22,31,35,40,45,48,49,50};
        int value = 48;
        int low = 0;
        int high = 12;
        while (low <= high) {
            int middle = (low + high) / 2;
            System.out.println("first = " + middle);
            if (value == array[middle]) {
                System.out.println("a " + array[middle]);
                System.out.println("result = " + middle);
                break;
            } else if (value < array[middle]) {
                System.out.println("b " + array[middle]);
                high = middle - 1;
            } else {
                System.out.println("c " + array[middle]);
                low = middle + 1;
            }
        }
    }
}
