package 图算法;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 拓扑排序
 * @date 2022/12/7 0:03
 */

public class TopologicalSorting {


    /*
     * @author: K0n9D1KuA
     * @description: 拓扑排序
     * @param: graph --> 图
     * @return: java.util.List<图算法.Node> --> 排序后的结点
     * @date: 2022/12/7 0:11
     */
    public static List<Node> topologicalSorting(Graph graph) {
        //key : 某一个node
        //value  : 剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //只有剩余入度为0的点才会进入这个队列
        LinkedList<Node> zeroInQueue = new LinkedList<>();
        //初始化 inMap 和 zeroInQueue
        for (Node node : graph.nodes.values()
        ) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                //入队列
                zeroInQueue.add(node);
                //排序
                Collections.sort(zeroInQueue, (o1, o2) -> o2.credit - o1.credit);
            }
        }
        //拓扑排序的结果依次放入 result
        ArrayList<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Collections.sort(zeroInQueue, (o1, o2) -> o2.credit - o1.credit);
            Node cur = zeroInQueue.poll();
            result.add(cur);
            //将他们所有连向的地方入度-1
            for (Node next : cur.nexts
            ) {
                inMap.put(next, inMap.get(next) - 1);
                //出现新的入度为0的结点 加入队列
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }

}
