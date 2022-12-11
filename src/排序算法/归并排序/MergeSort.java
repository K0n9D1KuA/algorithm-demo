package 排序算法.归并排序;


import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 归并排序
 * @date 2022/12/11 13:54
 */

public class MergeSort {

    private static int[] tmp = null;

    /*
     * @author: K0n9D1KuA
     * @description: 测试代码
     * @date: 2022/12/11 15:30
     */
    public static void main(String[] args) {

        int[] arr = {321, 52, 532, 532, 532, 53221, 12313, 3215, 643, 321321};
        tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @description: 归并排序
     * 函数功能：将区间划分为左右 直到划分为1个元素 然后合并左右
     * @author K0n9D1KuA
     * @date 2022/12/11 14:28
     * @version 1.0
     */

    public static void mergeSort(int[] arr, int left, int right) {
        //说明只有一个元素了 已经有序
        if (left >= right) {
            return;
        }
        //获得中间元素
        int mid = left + (right - left) / 2;
        //左区间
        mergeSort(arr, left, mid);
        //有区间
        mergeSort(arr, mid + 1, right);
        //走到这里 说明 左右子数组都是有序的了
        merge(arr, left, right, mid);
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int i = left;
        int p1 = left;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= right) {
            if (arr[p1] < arr[p2]) {
                tmp[i++] = arr[p1++];
            } else {
                tmp[i++] = arr[p2++];
            }
        }
        //说明左子组或者右子组的全部元素已经放入了临时数组中
        //如果是左子组没有遍历完 那么遍历完
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }

        //如果是右子组没有遍历完 那么遍历完
        while (p2 <= right) {
            tmp[i++] = arr[p2++];
        }
        //最后将临时数组的元素拷贝到原数组
        for (int j = left; j <= right; j++) {
            arr[j] = tmp[j];
        }

    }


}
