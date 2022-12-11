package 排序算法.直接插入排序;


import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 直接插入排序 直接插入排序是稳定性好的算法
 * @date 2022/12/10 19:31
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {321, 12, 54354, 35, 12, 3, 1232, 1, 32, 13, 21, 3, 5, 213, 53, 2, 532, 4, 32, 432, 4, 32};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insert(int[] arr) {
        //i 代表的是待插入的元素
        for (int i = 1; i < arr.length; i++) {
            //临时变量存放待插入的元素
            int temp = arr[i];
            //已排序区域的元素的索引
            int j = i - 1;
            //腾位置
            while (j >= 0) {
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    //这里说明了 前面都已经是有序了
                    //所以不用再交换
                    break;
                }
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    //交换的方法
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
