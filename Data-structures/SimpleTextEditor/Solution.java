import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Stack<String> history = new Stack<>();
        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                String w = sc.next();
                history.push(sb.toString());
                sb.append(w);
            } else if (type == 2) {
                int k = sc.nextInt();
                history.push(sb.toString());
                sb.delete(sb.length() - k, sb.length());
            } else if (type == 3) {
                int k = sc.nextInt();
                System.out.println(sb.charAt(k - 1));
            } else if (type == 4) {
                sb = new StringBuilder(history.pop());
            }
        }
    }
}