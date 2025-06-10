import java.util.*;

public class Solution {
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) map.put(s, map.getOrDefault(s, 0) + 1);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = map.getOrDefault(queries[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) strings[i] = sc.next();
        int q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) queries[i] = sc.next();
        int[] res = matchingStrings(strings, queries);
        for (int x : res) System.out.println(x);
    }
}