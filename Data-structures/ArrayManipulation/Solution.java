import java.util.*;

public class Solution {
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 2];
        for (int[] q : queries) {
            int a = q[0], b = q[1], k = q[2];
            arr[a] += k;
            arr[b + 1] -= k;
        }
        long max = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] queries = new int[m][3];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < 3; j++)
                queries[i][j] = sc.nextInt();
        System.out.println(arrayManipulation(n, queries));
    }
}