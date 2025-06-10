import java.util.*;

public class Solution {
    static int climbingLeaderboard(int[] ranked, int[] player) {
        int n = ranked.length;
        int m = player.length;
        int[] scores = Arrays.stream(ranked).distinct().toArray();
        int res = 0, i = scores.length - 1;
        for (int p : player) {
            while (i >= 0 && p >= scores[i]) i--;
            res = i + 2;
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ranked = new int[n];
        for (int i = 0; i < n; i++) ranked[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] player = new int[m];
        for (int i = 0; i < m; i++) player[i] = sc.nextInt();
        climbingLeaderboard(ranked, player);
    }
}