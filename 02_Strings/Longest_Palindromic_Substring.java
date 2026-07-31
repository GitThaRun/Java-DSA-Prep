// Given a string s, return the longest palindromic substring in s.

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.
// Example 2:

// Input: s = "cbbd"
// Output: "bb"

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n^2), Space Complexity : O(1)

public class Longest_Palindromic_Substring {
    private static int expandFromCenter(String s,int left,int right){
        while(left >= 0 && right < s.length() && 
              s.charAt(left) == s.charAt(right)){

                left--;
                right++;
              }
        return right - left - 1;
    }
    public static String longestPalindrome(String s) {
        int start = 0, maxLen = 1;

        if(s == null || s.length() < 2){
            return s;
        }

        for(int i = 0;i < s.length();i++){

            int oddLength = expandFromCenter(s,i,i);

            int evenLength = expandFromCenter(s,i,i+1);

            int curr_Length = Math.max(oddLength,evenLength);

            if(curr_Length > maxLen){
                maxLen = curr_Length;

                start = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(start,start + maxLen);
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
