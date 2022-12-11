package 排序算法.堆排序;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 堆
 * @date 2022/12/11 16:02
 */

public class Heap {
    //数组
    private int[] arr;
    //最后一个元素的索引
    private int lastIndex;

    //构造方法
    public Heap(int capacity) {
        this.arr = new int[capacity + 1];
        this.lastIndex = 0;
    }

    //交换的方法
    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //往堆中插入一个元素
    public void add(int addElement) {
        arr[++lastIndex] = addElement;
        System.out.println("当前添加的索引是" + lastIndex);
        //使用上浮算法 让索引k处的元素能在堆中处于正确的位置
        swim(lastIndex);
    }


    /*
     * @author: K0n9D1KuA
     * @description: 使用上浮算法 让索引lastIndex处的元素能在堆中处于正确的位置
     * @param: lastIndex 最新添加的元素的索引
     * @date: 2022/12/11 22:40
     */

    public void swim(int lastIndex) {

        //不断地循环 不断地比较当前结点的值和其父亲结点的值
        //如果当前结点的值大于父亲结点的值 那么就交换
        //注意特殊情况 当 lastIndex是1 那么 lastIndex / 2 又因为lastIndex默认是 0
        //所以千万不能交换！！ 所以另外一个条件是 lastIndex / 2 != 0
        while (arr[lastIndex] > arr[lastIndex / 2] && lastIndex / 2 != 0) {
            swap(arr, lastIndex, lastIndex / 2);
            lastIndex /= 2;
        }
    }

    //删除堆中最大的元素，并返回这个元素
    public int delMax() {
        if (lastIndex == 0) {
            //说明此时堆中已经没有元素了
            throw new RuntimeException("堆里面已经没有元素了...");
        }
        //第一个元素就是最大的元素
        int result = arr[1];
        //交换1和最大索引处的元素
        swap(arr, 1, lastIndex);
        //删除最大索引处的元素
        lastIndex--;
        //下沉算法 让堆重新变得有序
        sink(1);
        return result;
    }

    /*
     * @author: K0n9D1KuA
     * @description: 下沉算法 将临时根放到他应该存在的位置
     * 如果当前结点比其孩子节点的较大值小 那么就交换
     * 如果当前结点比其孩子节点的较大值大 那么说明此时临时根的位置就是合理的
     * @param: rootIndex 临时根的坐标 也就是1
     * @return:
     * @date: 2022/12/11 22:34
     */
    public void sink(int rootIndex) {
        //通过循环 如果当前结点比其孩子节点的较大值小
        //那么就交换
        //循环的条件是 2k<=N 如果连左孩子都没有 那么肯定没有右孩子
        while (2 * rootIndex <= lastIndex) {
            //获取当前结点的子结点中的较大值
            //记录当前结点的子结点中较大值的索引
            int maxIndexOfTwoChildren = 0;
            if (2 * rootIndex + 1 > lastIndex) {
                //说明只有左孩子
                maxIndexOfTwoChildren = 2 * rootIndex;
            } else {
                //说明左 右孩子都有
                //记录当前结点的子结点中较大值的索引
                maxIndexOfTwoChildren = arr[2 * rootIndex + 1] > arr[2 * rootIndex] ? 2 * rootIndex + 1 : 2 * rootIndex;
            }
            //小于当前结点的子结点中的较大值 -> 交换
            if (arr[rootIndex] < arr[maxIndexOfTwoChildren]) {
                swap(arr, rootIndex, maxIndexOfTwoChildren);
                rootIndex = maxIndexOfTwoChildren;
                //说明不用调整了
            } else {
                return;
            }
        }
    }

}
