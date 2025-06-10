import java.util.*;

public class Solution {
    static void almostSorted(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < n - 1 && arr[l] < arr[l + 1]) l++;
        while (r > 0 && arr[r] > arr[r - 1]) r--;
        if (l == r) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
        int[] temp = arr.clone();
        swap(temp, l, r);
        if (isSorted(temp)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
        temp = arr.clone();
        reverse(temp, l, r);
        if (isSorted(temp)) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
            return;
        }
        System.out.println("no");
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) swap(arr, i++, j--);
    }

    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        almostSorted(arr);
    }
}