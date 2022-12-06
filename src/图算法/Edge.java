package 图算法;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 图中的边
 * @date 2022/12/6 22:41
 */

public class Edge {
    //权值
    public int weight;
    //从哪里来
    public Node from;
    //到哪里去
    public Node to;

    //构造方法
    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
