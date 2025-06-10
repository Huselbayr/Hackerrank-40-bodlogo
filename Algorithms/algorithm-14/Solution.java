import java.util.*;

public class Solution {
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int L = s.length();
        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));
        if (rows * cols < L) rows++;
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int idx = r * cols + c;
                if (idx < L) sb.append(s.charAt(idx));
            }
            sb.append(' ');
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(encryption(s));
    }
}