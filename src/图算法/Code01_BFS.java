package 图算法;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 宽度优先遍历
 * @date 2022/12/6 23:16
 */

public class Code01_BFS {
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        //队列
        Queue<Node> queue = new LinkedList<>();
        //set 如果set中有node  那么他一定进入过queue
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //宽度优先遍历处理当前结点
            System.out.print(cur.value+" ");
            //处理他的每一个孩子
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }

    }
}
