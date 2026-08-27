// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

// A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.

// Example 1:

// Input: n = 1
// Output: 5
// Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

// Platform : Leetcode
// Level : Medium
// Approaches
// 1)Brute : Time Complexity : O(N), Space : O(N)
// 2)Optimal : Time Complexity : O(log n) , Space : O(1)
public class CountGoodNums {

    // Brute
    private static final long MOD = 1_000_000_007;

    // private static long count(int idx,int n){
    //     if(idx == n) return 1;

    //     long choices;

    //     if(idx % 2 == 0){
    //         choices = 5;
    //     }
    //     else{
    //         choices = 4;
    //     }

    //     long result = 0;

    //     for(int i = 0;i < choices;i++){
    //         result = (result + count(idx + 1,n)) % MOD;
    //     }
    //     return result;
    // }
    // public static int bruteCountGoodNumbers(int n){
    //     return (int) count(0,n);
    // }

     private static long power(long base, long exp){
        if(exp == 0) return 1;

        long half = power(base,exp / 2);

        long result = (half * half) % MOD;

        if(exp % 2 == 1){
            result = (result * base) % MOD;
        }
        return result;
    }

    public static long optimalCountGoodNumbers(int n){
         long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = power(5,evenPos);
        long oddWays = power(4,oddPos);

        return (int) ((evenWays * oddWays) % MOD);
    }
    public static void main(String[] args) {
        int n = 5;

        // System.out.println(bruteCountGoodNumbers(n));
        System.out.println(optimalCountGoodNumbers(n));
    }
}
