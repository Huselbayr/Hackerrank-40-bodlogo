import java.util.*;

public class Solution {
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], moves = cur[2];
            if (x == goalX && y == goalY) return moves;
            for (int d = 0; d < 4; d++) {
                int nx = x, ny = y;
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || grid[nx].charAt(ny) == 'X') break;
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, moves + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) grid[i] = sc.next();
        int startX = sc.nextInt(), startY = sc.nextInt();
        int goalX = sc.nextInt(), goalY = sc.nextInt();
        System.out.println(minimumMoves(grid, startX, startY, goalX, goalY));
    }
}