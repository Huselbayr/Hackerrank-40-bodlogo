import java.util.*;

public class Solution {
    static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        for (int i = sticks.length - 1; i >= 2; i--) {
            if (sticks[i - 2] + sticks[i - 1] > sticks[i]) {
                return new int[]{sticks[i - 2], sticks[i - 1], sticks[i]};
            }
        }
        return new int[]{-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] res = maximumPerimeterTriangle(arr);
        for (int x : res) System.out.print(x + " ");
    }
}