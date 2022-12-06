package 图算法;

public class test {
    public static void main(String[] args) {

        testBfs();
    }

    public static void testBfs() {
        //测试bfs
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        a.nexts.add(b);
        a.nexts.add(c);
        a.nexts.add(e);
        b.nexts.add(c);
        c.nexts.add(d);
        e.nexts.add(d);
        Code01_BFS.bfs(a);
        //打印结果 A B C E D
    }
}
