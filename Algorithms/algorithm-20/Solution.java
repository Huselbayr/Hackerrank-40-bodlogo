import java.util.*;

public class Solution {
    static int twoPluses(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = grid[i].charAt(j) == 'G' ? 1 : 0;

        List<int[]> pluses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int len = 0;
                while (isValid(g, i, j, len)) {
                    pluses.add(new int[]{i, j, len});
                    len++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < pluses.size(); i++) {
            boolean[][] mark = new boolean[n][m];
            int[] a = pluses.get(i);
            markPlus(mark, a[0], a[1], a[2]);
            for (int j = 0; j < pluses.size(); j++) {
                int[] b = pluses.get(j);
                if (!overlap(mark, b[0], b[1], b[2])) {
                    int area = area(a[2]) * area(b[2]);
                    if (area > max) max = area;
                }
            }
        }
        return max;
    }

    static boolean isValid(int[][] g, int x, int y, int len) {
        int n = g.length, m = g[0].length;
        if (x - len < 0 || x + len >= n || y - len < 0 || y + len >= m) return false;
        for (int d = 0; d <= len; d++) {
            if (g[x + d][y] == 0 || g[x - d][y] == 0 || g[x][y + d] == 0 || g[x][y - d] == 0)
                return false;
        }
        return true;
    }

    static void markPlus(boolean[][] mark, int x, int y, int len) {
        mark[x][y] = true;
        for (int d = 1; d <= len; d++) {
            mark[x + d][y] = true;
            mark[x - d][y] = true;
            mark[x][y + d] = true;
            mark[x][y - d] = true;
        }
    }

    static boolean overlap(boolean[][] mark, int x, int y, int len) {
        if (mark[x][y]) return true;
        for (int d = 1; d <= len; d++) {
            if (mark[x + d][y] || mark[x - d][y] || mark[x][y + d] || mark[x][y - d]) return true;
        }
        return false;
    }

    static int area(int len) {
        return 1 + 4 * len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) grid[i] = sc.next();
        System.out.println(twoPluses(grid));
    }
}