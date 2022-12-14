package 排序算法.冒泡排序;

import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 排序算法.冒泡排序 冒泡排序是稳定性好的算法
 * @date 2022/12/10 18:04
 */

public class BubbleSort {

    public static void main(String[] args) {
        //无序的
        int[] arr = {321, 45124, 54, 5, 6, 234, 432, 1213, 5, 5, 2, 3432432, 432112111, 532112111};
        //完全有序的
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        bubbleSort(arr);
        //打印排序后的结果
        System.out.println(Arrays.toString(arr));
    }


    //冒泡排序实现
    public static void bubbleSort(int[] arr) {
        //记录一下这是第几次冒泡
        int bubbleCount = 1;
        //最后一次交换索引的位置 他就代表着下一轮交换的次数
        int n = arr.length - 1;
        //外层循环表示冒泡的次数
        while (true) {
            //最后一次交换索引的位置 他就代表着下一轮交换的次数
            int lastIndex = 0;
            System.out.println("=====================第" + bubbleCount++ + "次冒泡=====================");
            for (int j = 0; j < n; j++) {
                System.out.println("比较次数" + (j + 1) + "次");
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    lastIndex = j;
                }
            }
            n = lastIndex;
            System.out.println("下一轮冒泡需要比较的次数" + n + "次");
            if (n == 0) {
                //说明已经是有序了  直接返回
                return;
            }
        }
    }

    //交换的方法
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    //完全有序的
    //=====================第1次冒泡=====================
    //比较次数1次
    //           比较次数2次
    //   比较次数3次
    //           比较次数4次
    //   比较次数5次
    //           比较次数6次
    //   比较次数7次
    //           比较次数8次
    //   下一轮冒泡需要比较的次数0次
    //[1,2,3,4,5,6,7,8,9]

    //无序的
//=====================第1次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            比较次数6次
//    比较次数7次
//            比较次数8次
//    比较次数9次
//            比较次数10次
//    比较次数11次
//            比较次数12次
//    比较次数13次
//            下一轮冒泡需要比较的次数9次
//=====================第2次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            比较次数6次
//    比较次数7次
//            比较次数8次
//    比较次数9次
//            下一轮冒泡需要比较的次数8次
//=====================第3次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            比较次数6次
//    比较次数7次
//            比较次数8次
//    下一轮冒泡需要比较的次数7次
//=====================第4次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            比较次数6次
//    比较次数7次
//            下一轮冒泡需要比较的次数6次
//=====================第5次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            比较次数6次
//    下一轮冒泡需要比较的次数5次
//=====================第6次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    比较次数5次
//            下一轮冒泡需要比较的次数4次
//=====================第7次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            比较次数4次
//    下一轮冒泡需要比较的次数3次
//=====================第8次冒泡=====================
//    比较次数1次
//            比较次数2次
//    比较次数3次
//            下一轮冒泡需要比较的次数2次
//=====================第9次冒泡=====================
//    比较次数1次
//            比较次数2次
//    下一轮冒泡需要比较的次数1次
//=====================第10次冒泡=====================
//    比较次数1次
//            下一轮冒泡需要比较的次数0次
//[2, 5, 5, 5, 6, 54, 234, 321, 432, 1213, 45124, 3432432, 432112111, 532112111]


}
