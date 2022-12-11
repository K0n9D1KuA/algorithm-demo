package 排序算法.堆排序;

public class TestHeap {
    public static void main(String[] args) {
        //创建堆对象
        Heap heap = new Heap(4);
        heap.add(8);
        heap.add(3);
        heap.add(6);
        heap.add(3929);
        int result = 0;
        while ((result = heap.delMax()) != -90090) {
            System.out.println(result);
        }
    }
}
