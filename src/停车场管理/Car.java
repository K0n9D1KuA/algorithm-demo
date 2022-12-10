package 停车场管理;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 车辆信息
 * @date 2022/12/9 14:56
 */

public class Car {
    //离开或者到达 'A' 'D'
    private Character arriveOrLeave;
    //车牌号
    private Integer carNumber;
    //到达或者离开的时间
    private Integer time;

    public Car(Character arriveOrLeave, Integer carNumber, Integer time) {
        this.arriveOrLeave = arriveOrLeave;
        this.carNumber = carNumber;
        this.time = time;
    }

    public Character getArriveOrLeave() {
        return arriveOrLeave;
    }

    public void setArriveOrLeave(Character arriveOrLeave) {
        this.arriveOrLeave = arriveOrLeave;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
