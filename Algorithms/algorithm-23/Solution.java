import java.util.*;

public class Solution {
    static int nonDivisibleSubset(int k, int[] S) {
        int[] rem = new int[k];
        for (int s : S) rem[s % k]++;
        int count = Math.min(rem[0], 1);
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(rem[i], rem[k - i]);
            }
        }
        if (k % 2 == 0) count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] S = new int[n];
        for (int i = 0; i < n; i++) S[i] = sc.nextInt();
        System.out.println(nonDivisibleSubset(k, S));
    }
}