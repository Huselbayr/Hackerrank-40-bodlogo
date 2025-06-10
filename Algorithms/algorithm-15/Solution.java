import java.util.*;

public class Solution {
    static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i == -1) return "no answer";
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        Arrays.sort(arr, i + 1, arr.length);
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String w = sc.next();
            System.out.println(biggerIsGreater(w));
        }
    }
}