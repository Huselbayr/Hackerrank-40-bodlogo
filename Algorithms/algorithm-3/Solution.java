import java.util.*;

public class Solution {
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        List<Integer> important = new ArrayList<>();
        for (int[] c : contests) {
            if (c[1] == 1) important.add(c[0]);
            else luck += c[0];
        }
        Collections.sort(important, Collections.reverseOrder());
        for (int i = 0; i < important.size(); i++) {
            if (i < k) luck += important.get(i);
            else luck -= important.get(i);
        }
        return luck;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] contests = new int[n][2];
        for (int i = 0; i < n; i++) {
            contests[i][0] = sc.nextInt();
            contests[i][1] = sc.nextInt();
        }
        System.out.println(luckBalance(k, contests));
    }
}
