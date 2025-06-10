import java.util.*;

class Node {
    int data;
    char c;
    Node left, right;
}

public class Solution {
    static void decode(String s, Node root) {
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            curr = (s.charAt(i) == '0') ? curr.left : curr.right;
            if (curr.left == null && curr.right == null) {
                System.out.print(curr.c);
                curr = root;
            }
        }
    }

    // Жишээ main функц (мод үүсгэх хэсгийг өөрийн хэрэгцээнд тааруулж өөрчилнө)
    public static void main(String[] args) {
        // Node root = ...; // Huffman мод үүсгэнэ
        // String s = ...;  // Кодчилсон стринг
        // decode(s, root);
    }
}