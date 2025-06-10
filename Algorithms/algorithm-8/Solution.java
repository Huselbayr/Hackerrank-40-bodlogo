import java.util.*;

public class Solution {
    static String gridSearch(String[] G, String[] P) {
        int R = G.length, C = G[0].length();
        int r = P.length, c = P[0].length();
        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean found = true;
                for (int k = 0; k < r; k++) {
                    if (!G[i + k].substring(j, j + c).equals(P[k])) {
                        found = false;
                        break;
                    }
                }
                if (found) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int R = sc.nextInt(), C = sc.nextInt();
            String[] G = new String[R];
            for (int i = 0; i < R; i++) G[i] = sc.next();
            int r = sc.nextInt(), c = sc.nextInt();
            String[] P = new String[r];
            for (int i = 0; i < r; i++) P[i] = sc.next();
            System.out.println(gridSearch(G, P));
        }
    }
}