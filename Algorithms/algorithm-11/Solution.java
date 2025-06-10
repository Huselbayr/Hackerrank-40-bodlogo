import java.util.*;

public class Solution {
    static String organizingContainers(int[][] container) {
        int n = container.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += container[i][j];
                colSum[j] += container[i][j];
            }
        }
        Arrays.sort(rowSum);
        Arrays.sort(colSum);
        return Arrays.equals(rowSum, colSum) ? "Possible" : "Impossible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int n = sc.nextInt();
            int[][] container = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    container[i][j] = sc.nextInt();
            System.out.println(organizingContainers(container));
        }
    }
}