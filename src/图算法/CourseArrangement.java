package 图算法;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 课程编排
 * @date 2022/12/7 0:30
 */

public class CourseArrangement {
    //课程依赖图
    public static Graph graph;


    //课程依赖图的初始化
    static {
        graph = new Graph();
        //创建12个结点
        Node C01 = new Node("C01", 2);
        Node C02 = new Node("C02", 3);
        Node C03 = new Node("C03", 4);
        Node C04 = new Node("C04", 3);
        Node C05 = new Node("C05", 2);
        Node C06 = new Node("C06", 3);
        Node C07 = new Node("C07", 4);
        Node C08 = new Node("C08", 4);
        Node C09 = new Node("C09", 7);
        Node C10 = new Node("C10", 5);
        Node C11 = new Node("C11", 2);
        Node C12 = new Node("C12", 3);
        //连接关系
        C01.nexts.add(C02);
        C01.nexts.add(C03);
        C01.nexts.add(C12);
        C01.nexts.add(C04);
        C01.in = 0;

        C02.nexts.add(C03);
        C02.in = 1;

        C03.nexts.add(C05);
        C03.nexts.add(C07);
        C03.nexts.add(C08);
        C03.in = 2;

        C04.nexts.add(C05);
        C04.in = 1;

        C05.nexts.add(C07);
        C05.in = 2;

        C06.nexts.add(C08);
        C06.in = 1;

        C07.in = 2;


        C08.in = 2;


        C09.nexts.add(C12);
        C09.nexts.add(C10);
        C09.nexts.add(C11);
        C09.in = 0;

        C10.nexts.add(C12);
        C10.in = 1;

        C11.nexts.add(C06);
        C11.in = 1;

        C12.in = 3;
        graph.nodes.put(C01.value, C01);
        graph.nodes.put(C02.value, C02);
        graph.nodes.put(C03.value, C03);
        graph.nodes.put(C04.value, C04);
        graph.nodes.put(C05.value, C05);
        graph.nodes.put(C06.value, C06);
        graph.nodes.put(C07.value, C07);
        graph.nodes.put(C08.value, C08);
        graph.nodes.put(C09.value, C09);
        graph.nodes.put(C10.value, C10);
        graph.nodes.put(C11.value, C11);
        graph.nodes.put(C12.value, C12);


    }

    /*
     * @author: K0n9D1KuA
     * @description: 调用拓扑排序返回排序结果
     * @return: java.util.List<图算法.Node>  拓扑排序排序后的结果
     * @date: 2022/12/7 14:20
     */

    //调用拓扑排序返回排序结果
    public static List<Node> getResult() {
        return TopologicalSorting.topologicalSorting(graph);
    }

    /*
     * @author: K0n9D1KuA
     * @description: 排课 支持两种策略 1，尽量把课排到前几个学期 2，将课均匀地分布在每个学期
     * @param: semesterCount 学期数
     * @param: maxScore 每学期的最大学分上限
     * @param: arrangeCourseStrategy 排课策略 0 --> 尽量把课排到前几个学期  1--> 将课均匀地分布在每个学期
     * @return: java.util.List<java.util.List<图算法.Node>> 安排好的学期
     * @date: 2022/12/7 14:34
     */
    public static List<List<Node>> arrangeCourse(Integer semesterCount, Integer maxScore, Integer arrangeCourseStrategy) {


        //拓扑排序后的结果
        List<Node> sortedCourses = getResult();
        //总的结果集 --> 放置安排好的学期
        List<List<Node>> arrangeSemesters = new ArrayList<>();
        //初始化学期
        for (int i = 0; i < semesterCount; i++) {
            arrangeSemesters.add(new ArrayList<Node>());
        }
        //策略选择
        // 0 --> 尽量把课排到前几个学期  1--> 将课均匀地分布在每个学期
        if (arrangeCourseStrategy == 0) {
            arrangeQuickly(sortedCourses, arrangeSemesters, maxScore);
        } else {
            arrangeAverage(sortedCourses, arrangeSemesters, maxScore);
        }

        return arrangeSemesters;

    }

    /*
     * @author: K0n9D1KuA
     * @description: 排课策略:尽快的将课程安排到完 也就是说 尽量将课程安排到前几个星期
     * @param: sortedCourses 经过拓扑排序排好的课程
     * @param: arrangeSemesters 所有学期
     * @param: maxScore 每个学期学分上限
     * @return: null 无
     * @date: 2022/12/7 14:31
     */

    private static void arrangeQuickly(List<Node> sortedCourses, List<List<Node>> arrangeSemesters, int maxScore) {

        int semesterCount = arrangeSemesters.size();
        //记录已经安排过的课 --> 已经安排过的课不在安排
        HashSet<Node> set = new HashSet<>();
        int[] score = new int[semesterCount];
        //初始化每学期已选总分 都初始化为0
        for (int i = 0; i < semesterCount; i++) {
            score[i] = 0;
        }
        sortedCourses.forEach(course ->
                {
                    for (int i = 0; i < semesterCount; i++) {
                        //获得某学期的所有课程
                        List<Node> currentCourses = arrangeSemesters.get(i);
                        //如果该学期的所有课程的nexts包含当前课程 那么不能在同一个学期上
                        boolean hasCurCourse = false;
                        for (Node curCourse : currentCourses
                        ) {
                            if (curCourse.nexts.contains(course)) {
                                hasCurCourse = true;
                            }
                        }
                        //当前学期学分已经超过总分 或者 该学期的所有课程的nexts包含当前课程 那么不能在同一个学期上
                        if (score[i] + course.credit > maxScore || hasCurCourse) {
                            //当前学期学分已经超了 或者 该学期的所有课程的nexts包含当前课程 --> 直接跳过当前学期
                            continue;
                        }
                        //学分没超过 && 当前课程没有被安排过
                        if (!set.contains(course)) {
                            currentCourses.add(course);
                            score[i] += course.credit;
                            set.add(course);
                        }

                    }
                }
        );
    }


    /*
     * @author: K0n9D1KuA
     * @description:排课策略：各学期的课程尽量均匀
     * @param: sortedCourses 经拓扑排序排好的课程
     * @param: arrangeSemesters 所有学期
     * @param: maxScore 每学期选课学分上限
     * @return: 无
     * @date: 2022/12/7 14:37
     */
    private static void arrangeAverage(List<Node> sortedCourses, List<List<Node>> arrangeSemesters, int maxScore) {


        int semesterCount = arrangeSemesters.size();
        //记录已经安排过的课 --> 已经安排过的课不在安排
        HashSet<Node> set = new HashSet<>();
        int[] score = new int[semesterCount];
        //初始化每学期已选总分 都初始化为0
        for (int i = 0; i < semesterCount; i++) {
            score[i] = 0;
        }

        //获得每学期应该安置的课程数的最大值
        final int maxCourseCountInOneSemester = sortedCourses.size() % semesterCount == 0
                ? sortedCourses.size() / semesterCount
                : sortedCourses.size() / semesterCount + 1;
        //记录每学期已选课程数量
        int selectCourseCount[] = new int[semesterCount];
        for (int i = 0; i < semesterCount; i++) {
            selectCourseCount[i] = 0;
        }
        sortedCourses.forEach(course ->
                {
                    for (int i = 0; i < semesterCount; i++) {
                        //获得某学期的所有课程
                        List<Node> currentCourses = arrangeSemesters.get(i);
                        //如果该学期的所有课程的nexts包含当前课程 那么不能在同一个学期上
                        boolean hasCurCourse = false;
                        //判断该学期的所有课程的nexts是否包含当前课程
                        for (Node curCourse : currentCourses
                        ) {
                            if (curCourse.nexts.contains(course)) {
                                hasCurCourse = true;
                            }
                        }
                        //当前学期学分已经超过每学期学分上限 或者 该学期的所有课程的nexts包含当前课程 或者 每学期的课程数量已经满了
                        if (score[i] + course.credit > maxScore || selectCourseCount[i] + 1 > maxCourseCountInOneSemester || hasCurCourse) {
                            //当前学期学分已经超过每学期学分上限  或者 该学期的所有课程的nexts包含当前课程 或者 每学期的课程数量已经满了 直接跳过当前学期
                            continue;
                        }
                        //学分没超过 && 当前课程没有被安排过 && 每学期的课程上限 < maxCourseCountInOneSemester
                        if (!set.contains(course)) {
                            currentCourses.add(course);
                            score[i] += course.credit;
                            selectCourseCount[i]++;
                            set.add(course);
                        }

                    }
                }
        );
    }


}
