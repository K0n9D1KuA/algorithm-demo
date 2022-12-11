package 排序算法.堆排序;

import java.util.Arrays;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 堆排序
 * @date 2022/12/11 15:54
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,   14};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] source) {

        int[] heap = new int[source.length + 1];
        //构建堆
        createHeap(source, heap);
        //记录未排序元素的最大索引
        int N = heap.length - 1;
        while (N != 1) {
            swap(heap, 1, N);
            N--;
            //对索引1处的元素做下沉调整
            sink(heap, 1, N);
        }
        //把heap中的数据复制到原来的数据
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    /*
     * @author: K0n9D1KuA
     * @description: 交换的方法
     * @date: 2022/12/11 15:58
     */

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
     * @author: K0n9D1KuA
     * @description: 创建堆的过程
     * @param: source 原始数组
     * @param: heap 即将常见好的堆
     * @date: 2022/12/11 22:59
     */
    public static void createHeap(int[] source, int[] heap) {
        //将source中的元素拷贝到heap中
        System.arraycopy(source, 0, heap, 1, source.length);
        //对堆中的元素做下沉调整，从最后一个非叶子节点调整最后一个非叶子结点在
        //heap中的坐标就是source.length/2
        //调整完了 再-- 知道下沉根
        for (int i = source.length / 2; i > 0; i--) {
            //开始下沉
            sink(heap, i, source.length);
        }
        //堆构建完毕

    }

    public static void sink(int[] heap, int target, int range) {
        //左孩子不能超过索引位置
        while (2 * target <= range) {
            int maxIndexOfTwoChildren = 0;
            //如果只有左孩子
            if (2 * target + 1 > range) {
                maxIndexOfTwoChildren = 2 * target;
            } else {
                //左右孩子都有
                maxIndexOfTwoChildren = heap[2 * target]
                        > heap[2 * target + 1]
                        ? 2 * target
                        : 2 * target + 1;
            }
            //如果小于孩子结点中的较大值 那么就下沉
            if (heap[target] < heap[maxIndexOfTwoChildren]) {
                swap(heap, target, maxIndexOfTwoChildren);
                target = maxIndexOfTwoChildren;
            } else {
                //说明不用调整了
                return;
            }
        }
    }

}
