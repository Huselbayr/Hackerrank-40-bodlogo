import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<Integer> stackNewest = new Stack<>();
        Stack<Integer> stackOldest = new Stack<>();
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                stackNewest.push(x);
            } else if (type == 2) {
                if (stackOldest.isEmpty())
                    while (!stackNewest.isEmpty())
                        stackOldest.push(stackNewest.pop());
                stackOldest.pop();
            } else if (type == 3) {
                if (stackOldest.isEmpty())
                    while (!stackNewest.isEmpty())
                        stackOldest.push(stackNewest.pop());
                System.out.println(stackOldest.peek());
            }
        }
    }
}