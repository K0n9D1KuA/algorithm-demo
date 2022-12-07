package 图算法;


import java.util.ArrayList;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 图中的点
 * @date 2022/12/6 22:38
 */

public class Node {
    //点上的值
    public String value;
    //分数
    public Integer credit;
    //入度 有多少个点指向自己
    public int in;
    //出度
    public int out;
    //他的直接邻居
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(String value, Integer credit) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
        this.credit = credit;
    }
}
