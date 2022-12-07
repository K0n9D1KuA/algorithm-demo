package 图算法;

import java.util.List;

public class test {
    public static void main(String[] args) {

//        testBfs();
        courseArrange();
    }

    public static void testBfs() {
//        //测试bfs
//        Node a = new Node("A");
//        Node b = new Node("B");
//        Node c = new Node("C");
//        Node d = new Node("D");
//        Node e = new Node("E");
//        a.nexts.add(b);
//        a.nexts.add(c);
//        a.nexts.add(e);
//        b.nexts.add(c);
//        c.nexts.add(d);
//        e.nexts.add(d);
//        Code01_BFS.bfs(a);
        //打印结果 A B C E D
    }

    public static void courseArrange() {
        Integer arrangeCourseStrategy = 0;
        List<List<Node>> result = CourseArrangement.arrangeCourse(6, 10, arrangeCourseStrategy);
        if (arrangeCourseStrategy == 1) {
            System.out.println("各学期的课程尽量均匀==================");
            for (int i = 0; i < result.size(); i++) {
                //获得当前学期
                List<Node> curSemester = result.get(i);
                //打印结果
                System.out.print("第" + (i + 1) + "学期课程安排：");
                curSemester.forEach(cs -> {
                    System.out.print(" 课程: " + cs.value + " 学分：" + cs.credit);
                });
                System.out.print("\n");
            }
        } else {
            System.out.println("尽快的将课程安排到前几个学期内==================");
            for (int i = 0; i < result.size(); i++) {
                //获得当前学期
                List<Node> curSemester = result.get(i);
                //打印结果
                System.out.print("第" + (i + 1) + "学期课程安排：");
                curSemester.forEach(cs -> {
                    System.out.print(" 课程: " + cs.value + " 学分：" + cs.credit);
                });
                System.out.print("\n");
            }
        }

    }
    //测试结果
//
    //尽快的将课程安排到前几个学期内==================
    //第1学期课程安排： 课程: C01 学分：2 课程: C09 学分：7
    //第2学期课程安排： 课程: C02 学分：3 课程: C04 学分：3 课程: C11 学分：2
    //第3学期课程安排： 课程: C10 学分：5 课程: C03 学分：4
    //第4学期课程安排： 课程: C12 学分：3 课程: C06 学分：3 课程: C05 学分：2
    //第5学期课程安排： 课程: C08 学分：4 课程: C07 学分：4
    //第6学期课程安排：
    //各学期的课程尽量均匀==================
    //第1学期课程安排： 课程: C01 学分：2 课程: C09 学分：7
    //第2学期课程安排： 课程: C02 学分：3 课程: C04 学分：3
    //第3学期课程安排： 课程: C10 学分：5 课程: C11 学分：2
    //第4学期课程安排： 课程: C03 学分：4 课程: C12 学分：3
    //第5学期课程安排： 课程: C06 学分：3 课程: C05 学分：2
    //第6学期课程安排： 课程: C08 学分：4 课程: C07 学分：4

}
