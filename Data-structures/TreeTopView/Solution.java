import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Solution {
    static void topView(Node root) {
        if (root == null) return;
        class QNode {
            Node node;
            int hd;
            QNode(Node n, int h) { node = n; hd = h; }
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<QNode> q = new LinkedList<>();
        q.add(new QNode(root, 0));
        while (!q.isEmpty()) {
            QNode curr = q.poll();
            if (!map.containsKey(curr.hd)) map.put(curr.hd, curr.node.data);
            if (curr.node.left != null) q.add(new QNode(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) q.add(new QNode(curr.node.right, curr.hd + 1));
        }
        for (int v : map.values()) System.out.print(v + " ");
    }

    // Жишээ main функц (мод үүсгэх хэсгийг өөрийн хэрэгцээнд тааруулж өөрчилнө)
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        topView(root);
    }
}