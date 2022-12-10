package 停车场管理;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class test {
    /*
     * @author: K0n9D1KuA
     * @description: 测试类代码
     * @param:
     * @return:
     * @date: 2022/12/10 16:59
     */

    public static void main(String[] args) {
        Park park = new Park(3);
        WaitQueue waitQueue = new WaitQueue(new ArrayDeque<>());
        Car a = new Car('A', 1, 2);
        Car a1 = new Car('A', 2, 3);
        Car a2 = new Car('A', 3, 4);
        Car a3 = new Car('A', 4, 5);
        Car a4 = new Car('D', 2, 8);
        Car a5 = new Car('D', 4, 10);
        Car a6 = new Car('D', 1, 11);
        List<Car> cars = Arrays.asList(a, a1, a2, a3, a4, a5, a6);
        cars.forEach(car -> {
            if (car.getArriveOrLeave().equals('A')) {
                //说明是到达
                park.parking(waitQueue, car);
            } else {
                //说明是离开
                park.leave(waitQueue, car);
            }
        });

        //打印结果：
        //1车于2进入停车场
        //2车于3进入停车场
        //3车于4进入停车场
        //4车于5进入便道等待
        //车牌号为2的车在8离开停车场,停留时间5产生的费用是5元
        //车牌号为4的车在8进入停车场
        //车牌号为4的车在10离开停车场,停留时间2产生的费用是2元
        //便道上没有车辆
        //车牌号为1的车在11离开停车场,停留时间9产生的费用是9元
        //便道上没有车辆
    }
}
