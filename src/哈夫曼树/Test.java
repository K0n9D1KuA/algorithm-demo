package 哈夫曼树;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //m1
        //n1
        //c2
        char[] chars = {
                ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        int[] weight = {
                186, 64, 13, 22, 32, 103, 21, 15, 47, 57, 1, 5, 32, 20, 57, 63, 15, 1, 48, 51, 80, 23, 8, 18, 1, 16, 1
        };
        List<TreeNode> huffmanTree = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            TreeNode treeNode = new TreeNode(chars[i], weight[i]);
            huffmanTree.add(treeNode);
        }
        //创建哈夫曼树
        HuffmanTree.createHuffmanTree(huffmanTree);
        List<String> codes = HuffmanTree.huffmanTreeEncoding(huffmanTree, weight.length);
        HuffmanTree.print(huffmanTree, weight.length, codes);
        HuffmanTree.encodingByOneString("THIS PROGRAM IS MY FAVORITE", chars, codes);
        HuffmanTree.decoding(
                "1101000101100011111100010001010011000010010101011001011101100011111110010100011111110011101011000001001001001101101010", huffmanTree);
    }
}
