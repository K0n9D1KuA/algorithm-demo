package 排序算法.堆排序;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 堆排序
 * @date 2022/12/11 15:54
 */

public class HeapSort {

    /*
     * @author: K0n9D1KuA
     * @description: 交换的方法
     * @param:
     * @return:
     * @date: 2022/12/11 15:58
     */

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void createHeap(int[] arr) {
    }

}
