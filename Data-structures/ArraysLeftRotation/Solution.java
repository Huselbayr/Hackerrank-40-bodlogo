import java.util.*;

public class Solution {
    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a[(i + d) % n];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int[] res = rotLeft(a, d);
        for (int x : res) System.out.print(x + " ");
    }
}