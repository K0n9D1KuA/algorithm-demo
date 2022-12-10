package 停车场管理;


import java.util.Queue;


/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 通过队列模拟便道
 * @date 2022/12/10 16:57
 */

public class WaitQueue {
    //模拟停车场满后  车辆等待的便道
    private Queue<Car> waitQueue;

    public Queue<Car> getWaitQueue() {
        return waitQueue;
    }

    public void setWaitQueue(Queue<Car> waitQueue) {
        this.waitQueue = waitQueue;
    }

    public WaitQueue(Queue<Car> waitQueue) {
        this.waitQueue = waitQueue;
    }

    //进入等待队列的方法
    public void add(Car waitingCar) {
        this.waitQueue.add(waitingCar);
    }

    //出队列进入停车场
    public Car get() {
        if (this.waitQueue.size() == 0) {
            //说明便道上没有车辆
            return null;
        }
        return this.waitQueue.poll();
    }


}
