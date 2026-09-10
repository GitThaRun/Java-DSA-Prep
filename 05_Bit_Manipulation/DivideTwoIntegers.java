// Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

// The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

// Return the quotient after dividing dividend by divisor.

// Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

// Example 1:

// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = 3.33333.. which is truncated to 3.

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(log N)^2, Space Complexity : O(1)

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;

        boolean sign = true;

        if(dividend >= 0 && divisor < 0){
            sign = false;
        }
        else if(dividend < 0 && divisor > 0){
            sign = false;
        }
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long ans = 0;

        while(n >= d){
            long temp = d;
            long multiple = 1;

            while((temp << 1) <= n){
                temp <<= 1;
                multiple <<= 1;
            }
            n -= temp;
            ans += multiple;
        }

        if(ans > Integer.MAX_VALUE && sign){
            return Integer.MAX_VALUE;
        }

        if(ans > Integer.MAX_VALUE && !sign){
            return Integer.MIN_VALUE;
        }

        return sign?(int) ans : (int) (-ans);
    }
    public static void main(String[] args) {
        int dividend = 10, divisor = 3;

        System.out.println(divide(dividend, divisor));
    }
}
