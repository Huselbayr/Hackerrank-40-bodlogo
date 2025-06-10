import java.util.*;

public class Solution {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> left = new HashMap<>();
        Map<Long, Long> right = new HashMap<>();
        for (long num : arr) right.put(num, right.getOrDefault(num, 0L) + 1);
        long count = 0;
        for (long num : arr) {
            right.put(num, right.get(num) - 1);
            if (num % r == 0) {
                long a = num / r, c = num * r;
                count += left.getOrDefault(a, 0L) * right.getOrDefault(c, 0L);
            }
            left.put(num, left.getOrDefault(num, 0L) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long r = sc.nextLong();
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(sc.nextLong());
        System.out.println(countTriplets(arr, r));
    }
}