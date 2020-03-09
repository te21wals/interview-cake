package interview.cake.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeTwoSortedArrays(int a[], int b[]) {
        int[] resultingArr = new int[a.length + b.length];

        int aCount = 0;
        int bCount = 0;
        int resultArrCount = 0;


        while (resultArrCount != resultingArr.length) {
            // a is exhausted
            if (aCount == a.length) {
                resultingArr[resultArrCount] = b[bCount];
                bCount++;
            }
            // b is exhausted
            else if (bCount == b.length) {
                resultingArr[resultArrCount] = a[aCount];
                aCount++;
            }
            // a[aCount] next
            else if (a[aCount] < b[bCount]) {
                resultingArr[resultArrCount] = a[aCount];
                aCount++;
            }
            // b[bCount] next
            else {
                resultingArr[resultArrCount] = b[bCount];
                bCount++;
            }
            resultArrCount++;
        }
        return resultingArr;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 7, 9};
        int[] b = new int[]{4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(mergeTwoSortedArrays(a, b)));
    }
}
