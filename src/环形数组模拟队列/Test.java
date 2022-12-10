package 环形数组模拟队列;

public class Test {

    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(3);
        circleArray.addQueue(1);
        circleArray.addQueue(2);
//        circleArray.addQueue(3);
        System.out.println("走的元素"+circleArray.getQueue());
        circleArray.addQueue(5);
        System.out.println("走的元素"+circleArray.getQueue());
        circleArray.addQueue(19);
        circleArray.showQueue();
    }
}
