import java.util.*;

public class Solution {
    static String larrysArray(int[] A) {
        int n = A.length;
        int swaps = 0;
        for (int i = 0; i < n - 2; i++) {
            while (A[i] != i + 1) {
                if (i + 2 >= n) break;
                rotate(A, i);
                swaps++;
            }
        }
        return (A[n - 2] < A[n - 1] && A[n - 2] == n - 1 && A[n - 1] == n) ? "YES" : "NO";
    }

    static void rotate(int[] A, int i) {
        int temp = A[i];
        A[i] = A[i + 1];
        A[i + 1] = A[i + 2];
        A[i + 2] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(larrysArray(arr));
        }
    }
}