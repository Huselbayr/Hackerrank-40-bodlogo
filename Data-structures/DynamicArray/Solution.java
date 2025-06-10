import java.util.*;

public class Solution {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) seqList.add(new ArrayList<>());
        List<Integer> res = new ArrayList<>();
        int lastAnswer = 0;
        for (List<Integer> q : queries) {
            int type = q.get(0), x = q.get(1), y = q.get(2);
            int idx = (x ^ lastAnswer) % n;
            if (type == 1) {
                seqList.get(idx).add(y);
            } else {
                lastAnswer = seqList.get(idx).get(y % seqList.get(idx).size());
                res.add(lastAnswer);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(sc.nextInt());
            query.add(sc.nextInt());
            query.add(sc.nextInt());
            queries.add(query);
        }
        List<Integer> res = dynamicArray(n, queries);
        for (int x : res) System.out.println(x);
    }
}