package 环形数组模拟队列;

public class ClassArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(3);
        circleArray.addQueue(1);
        circleArray.addQueue(2);
        System.out.println("走的元素"+circleArray.getQueue());
        circleArray.addQueue(5);
        System.out.println("走的元素"+circleArray.getQueue());
        circleArray.addQueue(19);
        System.out.println("走的元素"+circleArray.getQueue());
        circleArray.addQueue(77);
        circleArray.showQueue();
    }
}


class CircleArray {
    //表示数组的最大容量
    //什么时候表示队列满了？ (rear+1)%maxSize == front
    //什么时候队列为空？ rear == front 的时候
    //
    private int maxSize;
    //队列头 front指向队列的第一个元素 也就是说arr[front]就是队列的第一个元素
    private int front;
    //rear指向队列最后一个元素的后一个位置，因为希望空一个空间作为约定
    private int rear;
    //该数据用于存放数据，模拟队列
    private int[] arr;

    //构造方法
    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，不能假如数据~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，要取模
        rear = (rear + 1) % maxSize;
    }

    //取出数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空!");
        }
        //获得队列头元素
        int result = arr[front];
        //front往前移动
        front = (front + 1) % maxSize;
        return result;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        //为什么需要加 maxSize
        //有时候rear的下标会比front小
        //这个时候实际上rear是比front大一圈
        //类似于跑步多跑一圈 所以需要加一个maxSize保底
        //即使rear比front大也无所谓 因为 maxSize%maxSize = 0
        //所以即不会产生影响 也防止了负数的产生
        //思路：从front开始遍历 循环 (rear+maxSize-front) % maxSize 次
        for (int i = front; i < front + size(); i++) {
            //这里为什么要 i%maxSize
            //举一个例子
            //假设数组大小为 6 此时的 front走到了5的位置 元素数量是3
            //第一次打印 arr[5] 没啥问题
            //第二次打印 arr[6] 就数组越界了
            //实际上此时的 坐标6 就是 6%6 = 0
            System.out.println("第" + i + "个元素:" + arr[i%maxSize]);
        }

    }

    //获得当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
