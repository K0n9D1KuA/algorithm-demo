package 哈夫曼树;


import java.util.ArrayList;
import java.util.List;

/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 哈夫曼树
 * @date 2022/12/7 22:34
 */

public class HuffmanTree {
    /*
     * @author: K0n9D1KuA
     * @description: 创建一颗哈夫曼树
     * @param: huffmanTree 哈夫曼树叶子结点集合
     * @return: 无
     * @date: 2022/12/7 22:38
     */
    public static void createHuffmanTree(List<TreeNode> huffmanTree) {
        //获得叶子结点个数
        int countOfLeaveNode = huffmanTree.size();
        //二叉树的结点个数 = 度为2的结点个数 + 度为1的结点个数 + 度为0的结点个数
        //在构造哈夫曼树时,是从叶子节点向根节点的方向进行的,每次都是两个两个成对来形成一个新的分支节点,所以不存在度为1的节点
        //所以 度为1的结点的个数为0(哈夫曼树中)
        //又因为 度为2的结点的个数 = 度为0的结点的个数 -1
        //所以哈夫曼树结点的个数是  2*n0-1
        //n0是叶子结点  现在叶子节点的个数是countOfLeaveNode
        //所以哈夫曼树的结点个数是 2*countOfLeaveNode - 1
        //那么只需要创建2*countOfLeaveNode - 1 - countOfLeaveNode个结点
        //即只需要创建countOfLeaveNode - 1个结点
        //第countOfLeaveNode个结点的下标是 countOfLeaveNode -1
        //所以i从countOfLeaveNode开始循环
        //循环创建根结点
        for (int i = countOfLeaveNode; i < 2 * countOfLeaveNode - 1; i++) {
            //找出森林中根权值最小的两个结点
            int[] twoMinRoot = selectTheMostSmallestTwo(huffmanTree);
            //最小的坐标
            int m1 = twoMinRoot[0];
            //第二小的坐标
            int m2 = twoMinRoot[1];
            //最小的结点
            TreeNode treeNode1 = huffmanTree.get(m1);
            //第二小的结点
            TreeNode treeNode2 = huffmanTree.get(m2);
            //创建新的根结点
            TreeNode parent = new TreeNode();
            parent.setWeight(treeNode1.getWeight() + treeNode2.getWeight());
            parent.setParent(0);
            //左孩子
            parent.setlChild(m1);
            parent.setrChild(m2);
            treeNode1.setParent(i);
            treeNode2.setParent(i);
            //添加
            huffmanTree.add(parent);
        }

    }

    /*
     * @author: K0n9D1KuA
     * @description: 哈夫曼树编码
     * @param: huffmanTree 哈夫曼树所有结点
     * @param: countOfLeaveNode 哈夫曼树中叶子结点的个数
     * @return: java.util.List<java.lang.String>
     * @date: 2022/12/7 23:15
     */
    public static List<String> huffmanTreeEncoding(List<TreeNode> huffmanTree, int countOfLeaveNode) {


        List<String> code = new ArrayList<>(1000);
        //遍历所有结点
        for (int i = 0; i < countOfLeaveNode; i++) {
            //获得当前结点
            TreeNode curTreeNode = huffmanTree.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            while (curTreeNode.getParent() != 0) {
                //获得其父亲
                TreeNode parent = huffmanTree.get(curTreeNode.getParent());
                if (parent.getlChild() == huffmanTree.indexOf(curTreeNode)) {
                    //说明当前结点是其父亲结点的左孩子 该拼接0
                    stringBuilder.append("0");
                }
                if (parent.getrChild() == huffmanTree.indexOf(curTreeNode)) {
                    //说明当前结点是其父亲结点的左孩子 该拼接0
                    stringBuilder.append("1");
                }
                //更新
                curTreeNode = parent;
            }
            //需要将字符串倒过来
            StringBuilder reverse = stringBuilder.reverse();
            code.add(reverse.toString());
        }
        return code;
    }

    /*
     * @author: K0n9D1KuA
     * @description: 打印哈夫曼树编码
     * @param: huffmanTree 哈夫曼树所有结点
     * @param: countOfLeaveNode 哈夫曼树叶子结点数量
     * @param: code 哈夫曼树编码
     * @date: 2022/12/7 23:19
     */
    public static void print(List<TreeNode> huffmanTree, int countOfLeaveNode, List<String> code) {


        for (int i = 0; i < countOfLeaveNode; i++) {
            //获得当前结点
            TreeNode curTreeNode = huffmanTree.get(i);
            System.out.println("原字符:" + curTreeNode.getCharacter() + " 编码:" + code.get(i));
        }
    }


    /*
     * @author: K0n9D1KuA
     * @description: 查询森林中根权值最小的两个结点
     * @param: huffmanTree 哈夫曼树结点结婚
     * @return:
     * @return: int[] 存储森林中根权值最小的两个结点的下标
     * @date: 2022/12/7 22:40
     */

    public static int[] selectTheMostSmallestTwo(List<TreeNode> huffmanTree) {
        //用来存储森林中根权值最小的两个结点的下标
        int[] twoMinRoot = new int[2];
        //获得huffmanTree结点的个数
        int size = huffmanTree.size();
        int min1 = 99999;
        int min2 = 99999;
        //寻找根权值最小的结点
        for (int i = 0; i < size; i++) {
            //获得当前结点
            TreeNode curTreeNode = huffmanTree.get(i);
            //寻找最小的根
            //必须足够小  且是根
            //根的特征就是 它的parent = 0
            if (min1 > curTreeNode.getWeight() && curTreeNode.getParent() == 0) {
                min1 = curTreeNode.getWeight();
                twoMinRoot[0] = i;
            }
        }
        //寻找第二小的根
        for (int i = 0; i < size; i++) {
            //获得当前结点
            TreeNode curTreeNode = huffmanTree.get(i);
            //寻找最小的根
            //必须足够小  且是根
            //根的特征就是 它的parent = 0
            //而且它必须是第二小 也就意味着
            //他的下标不能是twoMinRoot[0]
            if (min2 > curTreeNode.getWeight() && curTreeNode.getParent() == 0 && i != twoMinRoot[0]) {
                min2 = curTreeNode.getWeight();
                twoMinRoot[1] = i;
            }
        }
        return twoMinRoot;
    }

    public static void encodingByOneString(String originalString, char[] chars, List<String> codes) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = new String(chars);
        //遍历字符串
        char[] chars1 = originalString.toCharArray();
        for (char c : chars1
        ) {
            int i = s.indexOf(c);
            stringBuilder.append(codes.get(i));
        }
        System.out.println(stringBuilder.toString());
    }

    public static void decoding(String codes, List<TreeNode> huffmanTree) {
        //从根节点开始走
        int indexOfRoot = huffmanTree.size() - 1;
        //获得编码的长度
        int length = codes.length();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        TreeNode curNode = huffmanTree.get(indexOfRoot);
        while (i < length) {

            if (codes.charAt(i) == '0') {
                //走左子树
                curNode = huffmanTree.get(curNode.getlChild());
                //如果走到了叶子结点
                if (curNode.getlChild() == 0 && curNode.getrChild() == 0) {
                    stringBuilder.append(curNode.getCharacter());
                    //重新从根开始走
                    curNode = huffmanTree.get(indexOfRoot);
                }
            } else {
                //走右子树
                curNode = huffmanTree.get(curNode.getrChild());
                //如果走到了叶子结点
                if (curNode.getlChild() == 0 && curNode.getrChild() == 0) {
                    stringBuilder.append(curNode.getCharacter());
                    //重新从根开始走
                    curNode = huffmanTree.get(indexOfRoot);
                }
            }
            i++;
        }
        //最后打印结果
        System.out.println(stringBuilder.toString());
    }
}
