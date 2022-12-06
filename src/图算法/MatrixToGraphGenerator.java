package 图算法;

/**
 * @description:
 * 将这种数据结构的图描述转化为模板
 * [from to weight]
 * [from to weight]
 * [from to weight]
 * [from to weight]
 * @author K0n9D1KuA
 * @date 2022/12/6 23:10
 * @version 1.0
 */

public class MatrixToGraphGenerator {
//    public static Graph createGraph(Integer[][] matrix) {
//        //创建一个图
//        Graph graph = new Graph();
//        for (int i = 0; i < matrix.length; i++) {
//            // 第一列 from 第二列 to 第三列 边的权值
//            Integer from = matrix[i][0];
//            Integer to = matrix[i][1];
//            Integer weight = matrix[i][2];
//            //第一次遇到这个城市
//            if (!graph.nodes.containsKey(from)) {
//                graph.nodes.put(from, new Node(from));
//            }
//            //第一次遇到这个城市
//            if (!graph.nodes.containsKey(to)) {
//                graph.nodes.put(to, new Node(to));
//            }
//            Node fromNode = graph.nodes.get(from);
//            Node toNode = graph.nodes.get(to);
//            Edge newEdge = new Edge(weight, fromNode, toNode);
//            fromNode.nexts.add(toNode);
//            fromNode.out++;
//            toNode.in++;
//            fromNode.edges.add(newEdge);
//            graph.edges.add(newEdge);
//        }
//        return graph;
//    }

}
