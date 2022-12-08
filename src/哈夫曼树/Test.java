package 哈夫曼树;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //初始化字符与权重
        char[] chars = {
                ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        int[] weight = {
                186, 64, 13, 22, 32, 103, 21, 15, 47, 57, 1, 5, 32, 20, 57, 63, 15, 1, 48, 51, 80, 23, 8, 18, 1, 16, 1
        };
        //初始化哈夫曼树叶子节点
        List<TreeNode> huffmanTree = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            TreeNode treeNode = new TreeNode(chars[i], weight[i]);
            huffmanTree.add(treeNode);
        }
        //常见哈夫曼树所有结点
        HuffmanTree.createHuffmanTree(huffmanTree);
        //得到编码
        List<String> codes = HuffmanTree.huffmanTreeEncoding(huffmanTree, weight.length);
        //打印字符及其对应编码
        HuffmanTree.print(huffmanTree, weight.length, codes);
        //编码
        HuffmanTree.encodingByOneString("THIS PROGRAM IS MY FAVORITE", chars, codes);
        //译码
        HuffmanTree.decoding(
                "1101000101100011111100010001010011000010010101011001011101100011111110010100011111110011101011000001001001001101101010", huffmanTree);
    }
}
//打印结果
//原字符:  编码:111
// 原字符:A 编码:1010
// 原字符:B 编码:100000
// 原字符:C 编码:00000
// 原字符:D 编码:10110
// 原字符:E 编码:010
// 原字符:F 编码:110011
// 原字符:G 编码:100001
// 原字符:H 编码:0001
// 原字符:I 编码:0110
// 原字符:J 编码:1100001000
// 原字符:K 编码:11000011
// 原字符:L 编码:10111
// 原字符:M 编码:110010
// 原字符:N 编码:0111
// 原字符:O 编码:1001
// 原字符:P 编码:100010
// 原字符:Q 编码:1100001001
// 原字符:R 编码:0010
// 原字符:S 编码:0011
// 原字符:T 编码:1101
// 原字符:U 编码:00001
// 原字符:V 编码:1100000
// 原字符:W 编码:110001
// 原字符:X 编码:1100001010
// 原字符:Y 编码:100011
// 原字符:Z 编码:1100001011
// THIS PROGRAM IS MY FAVORITE 编码后的结果-》1101000101100011111100010001010011000010010101011001011101100011111110010100011111110011101011000001001001001101101010
// //1101000101100011111100010001010011000010010101011001011101100011111110010100011111110011101011000001001001001101101010 译码结果是-》THIS PROGRAM IS MY FAVORITE


