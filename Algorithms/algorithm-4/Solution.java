import java.util.*;

public class Solution {
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                int j = i, cycle = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j] - 1;
                    cycle++;
                }
                if (cycle > 1) swaps += cycle - 1;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(minimumSwaps(arr));
    }
}