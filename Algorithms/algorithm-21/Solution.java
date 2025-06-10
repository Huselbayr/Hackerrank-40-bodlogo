import java.util.*;

public class Solution {
    static String timeInWords(int h, int m) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
                "twenty seven", "twenty eight", "twenty nine"};
        if (m == 0) return nums[h] + " o' clock";
        if (m == 15) return "quarter past " + nums[h];
        if (m == 30) return "half past " + nums[h];
        if (m == 45) return "quarter to " + nums[h + 1];
        if (m < 30) return (m == 1 ? "one minute" : nums[m] + " minutes") + " past " + nums[h];
        return (60 - m == 1 ? "one minute" : nums[60 - m] + " minutes") + " to " + nums[h + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(timeInWords(h, m));
    }
}