package General;
// https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/description/
public class MinimumAdditionToMakeIntegerBeautiful {
    public static long makeIntegerBeautiful(long n, int target) {
        if (digitSum(n) <= target) return 0;
        double digit = 10.0d;
        long sum = 0;
        while (digitSum(n) > target) {
            long num = (long) (Math.ceil(n / digit) * digit);
            sum += num - n;
            n = num;
            digit *= 10.0;
        }
        return sum;
    }

    private static long digitSum(long num) {
        long sum = 0;
        while (num != 0) {
            long digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }


}
