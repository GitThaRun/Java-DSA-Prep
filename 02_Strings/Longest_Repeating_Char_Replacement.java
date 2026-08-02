// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// platform : Leetcode
// Level : Medium
// Time Complexity : O(n), Space Complexity : O(1)

public class Longest_Repeating_Char_Replacement {
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int maxlen = 0;
        int ans = 0;

        int[] freq = new int[26];

        for(int right = 0;right < s.length();right++){
            freq[s.charAt(right) - 'A']++;

            maxlen = Math.max(maxlen,freq[s.charAt(right) - 'A']);

            while((right - left + 1) - maxlen > k){
                freq[s.charAt(left) - 'A']--;

                left++;
            }
            ans = Math.max(ans,(right - left + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "BAABAABBBAAA";
        int k = 2;
        System.out.println(characterReplacement(s, k)); // Output: 4
    }
}
