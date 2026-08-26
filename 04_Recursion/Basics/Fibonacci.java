// Given an integer N. Print the Fibonacci series up to the Nth term.

// Examples
// Example 1:
// Input: N = 5
// Output: 0 1 1 2 3 5
// Explanation: 0 1 1 2 3 5 is the fibonacci series up to 5th term.(0 based indexing)

// Platform : Striver SDE Sheet
// Level : Easy
// Time Complexity : O(2 ^ N), Space Complexity : O(1)
public class Fibonacci {
    public static int fib(int n){
        if(n <= 1) return n;

        int last = fib(n - 1);
        int slast = fib(n - 2);

        return last + slast;
    }
    public static void main(String[] args) {
        int n = 10;

        System.out.println(fib(n));
    }
}
