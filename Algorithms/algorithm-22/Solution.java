import java.util.*;

public class Solution {
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int maxDist = Math.max(c[0], n - 1 - c[c.length - 1]);
        for (int i = 1; i < c.length; i++) {
            int dist = (c[i] - c[i - 1]) / 2;
            if (dist > maxDist) maxDist = dist;
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] c = new int[m];
        for (int i = 0; i < m; i++) c[i] = sc.nextInt();
        System.out.println(flatlandSpaceStations(n, c));
    }
}