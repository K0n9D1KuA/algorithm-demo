package 二分查找;


/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 二分查找
 * @date 2022/12/10 17:10
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int target = 6;
        int index = binarySearch(arr, target);
        System.out.println(index);

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int midIndex;
        while (left <= right) {
            midIndex = (left + right) >>> 1;
            if (arr[midIndex] == target) {
                return midIndex;
            } else if (arr[midIndex] > target) {
                right = midIndex - 1;
            } else {
                left = midIndex + 1;
            }
        }
        //说明找不到
        return -1;
    }
}
