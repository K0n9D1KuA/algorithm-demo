package 哈夫曼树;


/**
 * @author K0n9D1KuA
 * @version 1.0
 * @description: 哈夫曼树结点
 * @date 2022/12/7 22:35
 */

public class TreeNode {
    //权值
    private int weight;
    //代表字符
    private Character character;
    //父亲
    private int parent;
    //左孩子
    private int lChild;
    //右孩子
    private int rChild;

    //构造方法
    public TreeNode() {

    }

    public TreeNode(Character character, int weight) {
        this.weight = weight;
        this.character = character;
        this.parent = 0;
        this.rChild = 0;
        this.lChild = 0;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getlChild() {
        return lChild;
    }

    public void setlChild(int lChild) {
        this.lChild = lChild;
    }

    public int getrChild() {
        return rChild;
    }

    public void setrChild(int rChild) {
        this.rChild = rChild;
    }
}
