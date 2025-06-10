import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Solution {
    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Жишээ main функц (мод үүсгэх хэсгийг өөрийн хэрэгцээнд тааруулж өөрчилнө)
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(6);
        System.out.println(height(root));
    }
}