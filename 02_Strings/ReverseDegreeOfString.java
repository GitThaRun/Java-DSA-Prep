// Given a string s, calculate its reverse degree.

// The reverse degree is calculated as follows:

// For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
// Sum these products for all characters in the string.
// Return the reverse degree of s.

 
// Example 1:
// Input: s = "abc"
// Output: 148

// Platform : Leetcode
// Level : Easy
// Time Complexity : O(n), Space Complexity : O(1)
public class ReverseDegreeOfString {
     public static int reverseDegree(String s) {
        int sum = 0;
        int n = s.length();

        for(int i = 0;i < n;i++){
            sum += (i + 1) * ('z' - s.charAt(i) + 1);
        }

        return sum;
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s)); // Output: 148
    }
}
