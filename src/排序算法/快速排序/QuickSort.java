package 排序算法.快速排序;

import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 快速排序
 * @date 2022/12/10 20:58
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {231, 321, 5, 12532, 532, 532, 11, 436, 43, 432, 6, 346, 46312, 4, 43, 264};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quick(int[] arr, int l, int h) {
        //为什么会出现 l>=h的情况？
        //假设初始  2 3 4 5 1
        //经过一次 partition_singleEdge 变为
        // 1 2 3 4 5
        //quick(arr, l, partition_singleEdge - 1) 中的partition就是 -1
        //此时就出现 l >= h的情况了
        if (l >= h) {
            return;
        }
        int partition = partition_doubleEdge(arr, l, h);
        quick(arr, l, partition - 1);
        quick(arr, partition + 1, h);
    }

    /*
     * @author: K0n9D1KuA
     * @description: 调整数组 找到基准值 基准值的左边都比它小 基准值的右边都比它大 单边循环
     * =============================================================================================
     * {231, 321, 5, 12532, 532, 532, 11, 436, 43, 432, 6, 346, 46312, 4, 43, 264}
     *  ↑                                                                       ↑
     * i/j                                                                  partition_singleEdge
     * {231, 321, 5, 12532, 532, 532, 11, 436, 43, 432, 6, 346, 46312, 4, 43, 264}
     *        ↑                                                                ↑
     *       i/j                                                            partition_singleEdge
     * {231, 321, 5, 12532, 532, 532, 11, 436, 43, 432, 6, 346, 46312, 4, 43, 264}
     *        ↑   ↑                                                             ↑
     *        i   j                                                         partition_singleEdge
     * {231, 5, 321 , 12532, 532, 532, 11, 436, 43, 432, 6, 346, 46312, 4, 43, 264}
     *           ↑      ↑                                                       ↑
     *           i      j                                                   partition_singleEdge
     * 。。。略
     * =============================================================================================
     * @param: arr 数组
     * @param: left 本次分区的左边界
     * @param: right 本次分区的右边界
     * @return: int 基准值最后所在下标
     * @date: 2022/12/10 21:30
     */

    private static int partition_singleEdge(int[] arr, int left, int right) {


        //返回值代表了基准点元素所在的正确索引
        //用它确定下一轮分区的边界
        //选择基准元素
        int partition = arr[right];
        //i保证i左边的值都比partition小
        int i = left;
        //循环到基准点之前的元素
        //遍历 比基准值小的都放在下标i的位置上
        for (int j = left; j < right; j++) {
            //比基准值小  那么就交换位置
            if (arr[j] < partition) {
                swap(arr, i, j);
                i++;
            }
        }
        //最后将基准值放在i处
        swap(arr, right, i);
        return i;
    }

    private static int partition_doubleEdge(int[] arr, int left, int right) {
        //返回值代表了基准点元素所在的正确下标
        //用它确定下一轮分区的边界
        //选择基准元素
        int partition = arr[left];
        //i去寻找比基准值大的元素
        int i = left;
        //j去寻找比基准值小的元素
        int j = right;
        //当i和j相等的时候 就说明本轮找到了基准值最后应该处于的位置
        while (i < j) {
            // j从右找比基准点小的元素
            // i从左找比基准点大的元素
            //----------------------------------------
            //  为什么这里还要判断 i < j ?
            //  一种情况
            //     [5,  1  ,2  ,3  ,6  ,7  ,8  ,9]
            //      ↑
            //  i/partition                     j
            //  如果不加i < j 最后就会变为
            //     [5,  1  ,2  ,3  ,6  ,7  ,8  ,9]
            //      ↑           ↑   ↑
            //  partition       j   i
            //  这样就会错过
            //----------------------------------------
            while (i < j && arr[j] > partition) {
                j--;
            }
            //----------------------------------------
            //为什么是arr[i] <= partition?
            //这是为了跳过开头元素 因为开头 partition 和 arr[i]指向的是一个元素
            while (i < j && arr[i] <= partition) {
                i++;
            }
            //i找到了比基准点大的元素
            //j找到了比基准点小的元素
            //交换
            swap(arr, i, j);
        }
        //最后将基准值和i/j坐标的值交换
        swap(arr, i, left);
        return i;
    }

    //交换的方法
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
