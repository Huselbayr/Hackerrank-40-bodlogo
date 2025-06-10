import java.util.*;

public class Solution {
    static int roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) return n * c_lib;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : cities) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int cost = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int citiesCount = dfs(i, adj, visited);
                cost += c_lib + (citiesCount - 1) * c_road;
            }
        }
        return cost;
    }

    static int dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) count += dfs(nei, adj, visited);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt(), c_lib = sc.nextInt(), c_road = sc.nextInt();
            int[][] cities = new int[m][2];
            for (int i = 0; i < m; i++) {
                cities[i][0] = sc.nextInt();
                cities[i][1] = sc.nextInt();
            }
            System.out.println(roadsAndLibraries(n, c_lib, c_road, cities));
        }
    }
}