package 停车场管理;


import java.util.Queue;
import java.util.Stack;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 停车场类
 * @date 2022/12/9 14:55
 */

public class Park {
    //停车场最大容量
    private Integer maxSize;
    //停车场
    private Stack<Car> park;
    //临时栈
    private Stack<Car> tempPark;
    //费用
    private Integer fare;

    public Park(Integer maxSize) {
        this.maxSize = maxSize;
        this.tempPark = new Stack<>();
        this.park = new Stack<>();
        this.fare = 1;

    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Stack<Car> getPark() {
        return park;
    }

    public void setPark(Stack<Car> park) {
        this.park = park;
    }

    public Stack<Car> getTempPark() {
        return tempPark;
    }

    public void setTempPark(Stack<Car> tempPark) {
        this.tempPark = tempPark;
    }

    //停车的方法
    public void parking(WaitQueue waitQueue, Car parkingCar) {
        if (this.park.size() == this.maxSize) {
            System.out.println(parkingCar.getCarNumber() + "车于" + parkingCar.getTime() + "进入便道等待");
            waitQueue.add(parkingCar);
        } else {
            System.out.println(parkingCar.getCarNumber() + "车于" + parkingCar.getTime() + "进入停车场");
            this.park.add(parkingCar);
        }
    }

    //车出来的方法
    public void leave(WaitQueue waitQueue, Car leaveCar) {
        while (park.peek().getCarNumber().intValue() != leaveCar.getCarNumber().intValue()) {
            //这辆车进入临时停车厂
            tempPark.add(park.pop());
        }
        //找到了要出来的那辆车
        Car leaveOne = park.pop();
        //算出在停车场内停留的时间
        int passTime = leaveCar.getTime().intValue() - leaveOne.getTime();
        System.out.println("车牌号为" + leaveOne.getCarNumber() + "的车在"
                + leaveCar.getTime() + "离开停车场,停留时间" + passTime + "产生的费用是"
                + this.fare * passTime + "元");
        //再把临时栈里面的车放入停车场
        while (tempPark.size() != 0) {
            this.park.add(tempPark.pop());
        }
        //同时唤醒便道上的车辆
        Car waitingCar = waitQueue.get();
        if (waitingCar == null) {
            System.out.println("便道上没有车辆");
            return;
        }

        waitingCar.setTime(leaveCar.getTime());
        System.out.println("车牌号为" + waitingCar.getCarNumber() + "的车在" + waitingCar.getTime() + "进入停车场");
        park.add(waitingCar);
    }
}
