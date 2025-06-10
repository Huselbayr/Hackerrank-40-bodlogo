import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Solution {
    static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;
        if (root.data > v1 && root.data > v2) return lca(root.left, v1, v2);
        if (root.data < v1 && root.data < v2) return lca(root.right, v1, v2);
        return root;
    }

    // Жишээ main функц (мод үүсгэх хэсгийг өөрийн хэрэгцээнд тааруулж өөрчилнө)
    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        Node res = lca(root, 1, 3);
        System.out.println(res.data);
    }
}