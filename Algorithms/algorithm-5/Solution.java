import java.util.*;

public class Solution {
    static int activityNotifications(int[] expenditure, int d) {
        int[] count = new int[201];
        for (int i = 0; i < d; i++) count[expenditure[i]]++;
        int notifications = 0;
        for (int i = d; i < expenditure.length; i++) {
            double median = getMedian(count, d);
            if (expenditure[i] >= 2 * median) notifications++;
            count[expenditure[i - d]]--;
            count[expenditure[i]]++;
        }
        return notifications;
    }

    static double getMedian(int[] count, int d) {
        int sum = 0;
        if (d % 2 == 1) {
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (sum > d / 2) return i;
            }
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < count.length; i++) {
                sum += count[i];
                if (first == -1 && sum >= d / 2) first = i;
                if (sum >= d / 2 + 1) {
                    second = i;
                    break;
                }
            }
            return (first + second) / 2.0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(activityNotifications(arr, d));
    }
}