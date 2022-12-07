package 图算法;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 表示一个图
 * @date 2022/12/6 22:36
 */

public class Graph {
    //key 城市编号 value 城市对应的结点
    public HashMap<String, Node> nodes;
    //边集合
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<String , Node>();
        edges = new HashSet<Edge>();
    }
}
