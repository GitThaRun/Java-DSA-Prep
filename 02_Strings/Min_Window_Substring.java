// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Platform : Leetcode
// Level : Hard
// Time Complexity : O(m + n), Space Complexity : O(1)

public class Min_Window_Substring {
    public static String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] freq = new int[128];

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        int left = 0,start = 0;
        int minlen = Integer.MAX_VALUE;
        int required = t.length();

        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);

            freq[ch]--;

            if(freq[ch] >= 0){
                required--;
            }

            while(required == 0){
                if(right - left + 1 < minlen){
                    minlen = right - left + 1;
                    start = left;
                } 

                char leftChar = s.charAt(left);

                freq[leftChar]++;
                if(freq[leftChar] > 0){
                    required++;
                }
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE?"" : s.substring(start,start + minlen);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
