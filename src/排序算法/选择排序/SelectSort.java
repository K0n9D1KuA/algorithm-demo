package 排序算法.选择排序;

import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 排序算法.选择排序 选择排序是稳定性不好的算法
 * @date 2022/12/10 18:58
 */

public class SelectSort {


    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {4, 5, 3, 2, 1};
        //{1, 2, 3, 4, 5}
        //{5, 4, 3, 2, 1}
        //{1,4,3,2,5}
        int[] arr = {1,2,3,5,6,7,2,52,67,21,22,55,25,32,21,15};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            //left表示的是本轮最小的元素应该被放置的下标
            //right表示的是本轮最大的元素应该被放置的小标
            //min是初始的最小值
            //max是初始的最大值
            int min = left;
            int max = right;
            //挑选出最大值和最小值所对应的下标
            for (int i = left; i <= right; i++) {
                if (arr[min] > arr[i]) {
                    min = i;
                }
                if (arr[max] < arr[i]) {
                    max = i;
                }
            }
            //是否交换
            if (left != min) {
                swap(arr, left, min);
            }
            //max != left注意这个条件
            if (right != max && max != left) {
                swap(arr, right, max);
            }
            left++;
            right--;
        }

    }


    //交换的方法
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
