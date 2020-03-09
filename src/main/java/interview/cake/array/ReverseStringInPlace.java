package interview.cake.array;

import java.util.Arrays;

public class ReverseStringInPlace {
    public static void reverseInPlace(String[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        String[] arr1 = new String[]{"T", "H", "O", "M", "A", "S"};

        reverseInPlace(arr1);
        System.out.println(Arrays.toString(arr1));

        reverseInPlace(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
