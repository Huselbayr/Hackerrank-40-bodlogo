import java.util.*;

public class Solution {
    static String bomberMan(int n, String[] grid) {
        if (n == 1) return String.join("\n", grid);
        int r = grid.length, c = grid[0].length();
        char[][] g = new char[r][c];
        for (int i = 0; i < r; i++) g[i] = grid[i].toCharArray();

        char[][] after3 = detonate(g);
        char[][] after5 = detonate(after3);

        if (n % 2 == 0) return repeatGrid(r, c, 'O');
        if ((n - 3) % 4 == 0) return gridToString(after3);
        return gridToString(after5);
    }

    static char[][] detonate(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        char[][] res = new char[r][c];
        for (char[] row : res) Arrays.fill(row, 'O');
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'O') {
                    res[i][j] = '.';
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d], nj = j + dy[d];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < c) res[ni][nj] = '.';
                    }
                }
            }
        }
        return res;
    }

    static String gridToString(char[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : grid) sb.append(new String(row)).append('\n');
        return sb.toString().trim();
    }

    static String repeatGrid(int r, int c, char ch) {
        StringBuilder sb = new StringBuilder();
        String row = String.valueOf(ch).repeat(c);
        for (int i = 0; i < r; i++) sb.append(row).append('\n');
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt(), n = sc.nextInt();
        String[] grid = new String[r];
        for (int i = 0; i < r; i++) grid[i] = sc.next();
        System.out.println(bomberMan(n, grid));
    }
}