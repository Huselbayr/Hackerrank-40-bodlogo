import java.util.*;

public class Solution {
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        unique.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                unique.add(ranked.get(i));
            }
        }
        int n = unique.size();
        int i = n - 1;
        for (int score : player) {
            while (i >= 0 && score >= unique.get(i)) {
                i--;
            }
            result.add(i + 2);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ranked = new ArrayList<>();
        for (int i = 0; i < n; i++) ranked.add(sc.nextInt());
        int m = sc.nextInt();
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < m; i++) player.add(sc.nextInt());
        List<Integer> res = climbingLeaderboard(ranked, player);
        for (int r : res) System.out.println(r);
    }
}
