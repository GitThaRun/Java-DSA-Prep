// Given a string s consisting only of characters a, b and c.
// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

// Example 1:

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 

// Platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class SubStrings_Containing_All_Chars {
    public static int numberOfSubstrings(String s) {
        
        int left = 0,count = 0;
        int n = s.length();
        int[] freq = new int[3];

        for(int right = 0;right < n;right++){
            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                count += n - right;

                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
