// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000

// Platform : Leetcode
// Level : Medium
// Approaches 
// 1)Brute Force Approach : Time Complexity : O(N), Space Complexity : O(1)
// 2)Optimal Approach : Time Complexity : O(logN), Space Complexity : O(1)

public class PowOfX {
    // Brute 
    public static double bruteMyPow(double x,int n){
        long exponent = n;
        boolean negative = exponent < 0;

        if(negative){
            exponent = -exponent;
        }
        double result = 1.0;

        for(int i = 0;i < exponent;i++){
            result *= x;
        }

        if(negative) return 1.0 / result;

        return result;
    }

    // Optimal
    private static double power(double x,long n){
            if(n == 0) return 1;

            if(n == 1) return x;

            if(n % 2 == 0){
                return power(x * x, n / 2);
            }
            return x * power(x,n - 1);
        }
    public static double optimalMyPow(double x,int n){
        long N = n;

        if(N < 0){
            return 1.0 / power(x,-N);
        }
        return power(x,N);
    }
    public static void main(String[] args) {
        double x = 2.0000;
        int n = 10;

        // System.out.println(bruteMyPow(x, n));
        System.out.println(optimalMyPow(x, n));
    }
}
