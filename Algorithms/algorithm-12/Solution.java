import java.util.*;

public class Solution {
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) obs.add(o[0] + "," + o[1]);
        int count = 0;
        for (int d = 0; d < 8; d++) {
            int r = r_q + dr[d], c = c_q + dc[d];
            while (r >= 1 && r <= n && c >= 1 && c <= n && !obs.contains(r + "," + c)) {
                count++;
                r += dr[d];
                c += dc[d];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int r_q = sc.nextInt(), c_q = sc.nextInt();
        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
            obstacles[i][0] = sc.nextInt();
            obstacles[i][1] = sc.nextInt();
        }
        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }
}